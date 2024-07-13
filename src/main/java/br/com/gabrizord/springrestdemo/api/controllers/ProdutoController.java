package br.com.gabrizord.springrestdemo.api.controllers;

import br.com.gabrizord.springrestdemo.domain.entities.Produto;
import br.com.gabrizord.springrestdemo.domain.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        try {
            Produto novoProduto = produtoService.createProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar produto: código duplicado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        return produtoService.deleteProduto(id);
    }
}
