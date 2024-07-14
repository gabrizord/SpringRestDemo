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
import java.util.Map;

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
    @Operation(summary = "Obtém um produto pelo ID", description = "Retorna um objeto do tipo Produto com o ID fornecido.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.getProdutoById(id));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualiza um produto pelo ID", description = "Fornece os novos dados para atualizar o produto com o ID fornecido.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @Valid @RequestBody Map<String, Object> produtoMap) {
        return ResponseEntity.ok(produtoService.updateProduto(id, produtoMap));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um produto pelo ID", description = "Exclui o produto com o ID fornecido.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public ResponseEntity<Produto> deleteProduto(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.deleteProduto(id));
    }
}
