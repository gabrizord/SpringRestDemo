package br.com.gabrizord.springrestdemo.api.controllers;

import br.com.gabrizord.springrestdemo.api.dto.PessoaFisicaDTO;
import br.com.gabrizord.springrestdemo.api.dto.PessoaJuridicaDTO;
import br.com.gabrizord.springrestdemo.domain.entities.Pessoa;
import br.com.gabrizord.springrestdemo.domain.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    @Operation(summary = "Obtém todas as pessoas", description = "Retorna uma lista de todas as pessoas cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de pessoas encontradas")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtém uma pessoa por ID", description = "Retorna os dados de uma pessoa específica pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Pessoa encontrada")
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @PostMapping("/fisica")
    @Operation(summary = "Cria uma nova pessoa física",
            description = "Fornece os dados necessários para registrar uma pessoa física, incluindo 'cpf' e 'rg'.")
    @ApiResponse(responseCode = "201", description = "Pessoa física criada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pessoa.class)))
    public ResponseEntity<Pessoa> createPessoaFisica(@Valid @RequestBody PessoaFisicaDTO pessoaFisicaDTO) {
        Pessoa pessoa = pessoaService.convertToEntity(pessoaFisicaDTO);
        Pessoa savedPessoa = pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPessoa);
    }

    @PostMapping("/juridica")
    @Operation(summary = "Cria uma nova pessoa jurídica",
            description = "Fornece os dados necessários para registrar uma pessoa jurídica, incluindo 'cnpj', 'inscricaoEstadual', etc.")
    @ApiResponse(responseCode = "201", description = "Pessoa jurídica criada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pessoa.class)))
    public ResponseEntity<Pessoa> createPessoaJuridica(@Valid @RequestBody PessoaJuridicaDTO pessoaJuridicaDTO) {
        Pessoa pessoa = pessoaService.convertToEntity(pessoaJuridicaDTO);
        Pessoa savedPessoa = pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPessoa);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualiza parcialmente os dados de uma pessoa", description = "Atualiza parcialmente os dados de uma pessoa existente pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Dados da pessoa atualizados com sucesso")
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @Valid @RequestBody Map<String, Object> updates) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(pessoaService.update(pessoa, updates));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma pessoa", description = "Remove uma pessoa do sistema pelo seu ID.")
    @ApiResponse(responseCode = "204", description = "Pessoa deletada com sucesso")
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    public ResponseEntity<Pessoa> deletePessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        pessoaService.deleteById(pessoa.getId());
        return ResponseEntity.ok(pessoa);
    }
}
