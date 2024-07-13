package br.com.gabrizord.springrestdemo.domain.services;

import br.com.gabrizord.springrestdemo.domain.entities.Produto;
import br.com.gabrizord.springrestdemo.domain.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto createProduto(Produto produto) throws DataIntegrityViolationException {
        try {
            return produtoRepository.save(produto);
        } catch (DataIntegrityViolationException e) {
            // Handle the exception when a duplicate entry occurs
            throw new DataIntegrityViolationException("Erro ao criar produto: código duplicado", e);
        }
    }

    public ResponseEntity<Produto> getProdutoById(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<Produto> updateProduto(Long id, Produto produto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        produto.setId(id); // Ensure the product ID is set
        Produto updatedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @Transactional
    public ResponseEntity<Void> deleteProduto(Long id) {
        try {
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
