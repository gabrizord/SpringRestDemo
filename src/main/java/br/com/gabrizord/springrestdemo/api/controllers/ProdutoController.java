package br.com.gabrizord.springrestdemo.api.controllers;

import br.com.gabrizord.springrestdemo.api.dto.ProdutoDTO;
import br.com.gabrizord.springrestdemo.domain.entities.Produto;
import br.com.gabrizord.springrestdemo.domain.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @Operation(summary = "Obtém todos os produtos", description = "Retorna uma lista de todos os produtos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de produtos encontrada")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    @Operation(summary = "Cria um novo produto", description = "Fornece os dados necessários para registrar um novo produto.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public ResponseEntity<Produto> criarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = produtoService.toEntity(produtoDTO);
        return ResponseEntity.ok(produtoService.createProduto(produto));
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
