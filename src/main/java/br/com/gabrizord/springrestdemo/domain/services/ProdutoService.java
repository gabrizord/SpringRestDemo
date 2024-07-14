package br.com.gabrizord.springrestdemo.domain.services;

import br.com.gabrizord.springrestdemo.api.dto.ProdutoDTO;
import br.com.gabrizord.springrestdemo.domain.entities.Produto;
import br.com.gabrizord.springrestdemo.domain.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto createProduto(Produto produto) {
        if (produtoRepository.existsByCodigo(produto.getCodigo())) {
            throw new IllegalArgumentException("Ja existe um produto com o mesmo Codigo");
        }
        return this.produtoRepository.save(produto);
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto not found with ID: " + id));
    }

    @Transactional
    public Produto updateProduto(Long id, Map<String, Object> produtoMap) {
        Produto produto = getProdutoById(id);

        for (Map.Entry<String, Object> entry : produtoMap.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            try {
                Field field = Produto.class.getDeclaredField(fieldName);
                field.setAccessible(true);

                if (field.getType() == BigDecimal.class && fieldValue instanceof Number) {
                    field.set(produto, BigDecimal.valueOf(((Number) fieldValue).doubleValue()));
                } else if (field.getType().isAssignableFrom(fieldValue.getClass())) {
                    field.set(produto, fieldValue);
                } else {
                    throw new IllegalArgumentException("Tipo de valor incompatível para o campo: " + fieldName);
                }
            } catch (NoSuchFieldException | IllegalAccessException | NullPointerException e) {
                throw new IllegalArgumentException("Erro ao acessar o campo: " + fieldName);
            }
        }

        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto deleteProduto(Long id) {
        Produto produto = getProdutoById(id);
        produtoRepository.deleteById(id);
        return produto;
    }

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }

    public Produto toEntity(ProdutoDTO produtoDTO) {
        return new Produto(produtoDTO.getCodigo(), produtoDTO.getNome(), produtoDTO.getDescricao(), produtoDTO.getNcm(), produtoDTO.getCst(),
                produtoDTO.getCfop(), produtoDTO.getUnidade(), produtoDTO.getQuantidade(), produtoDTO.getValorUnitario(),
                produtoDTO.getValorTotal(), produtoDTO.getBaseCalculoIcms(), produtoDTO.getValorIcms(),
                produtoDTO.getAliquotaIcms(), produtoDTO.getInformacoesAdicionais());
    }
}
