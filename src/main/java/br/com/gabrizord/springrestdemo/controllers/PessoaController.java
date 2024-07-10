package br.com.gabrizord.springrestdemo.controllers;

import br.com.gabrizord.springrestdemo.dtos.PessoaFisicaDTO;
import br.com.gabrizord.springrestdemo.dtos.PessoaJuridicaDTO;
import br.com.gabrizord.springrestdemo.entities.Pessoa;
import br.com.gabrizord.springrestdemo.dtos.PessoaDTO;
import br.com.gabrizord.springrestdemo.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    @Operation(summary = "Obtém todas as pessoas", description = "Retorna uma lista de todas as pessoas cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de pessoas encontradas")
    public List<Pessoa> getAllPessoas() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtém uma pessoa por ID", description = "Retorna os dados de uma pessoa específica pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Pessoa encontrada")
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados de uma pessoa", description = "Atualiza os dados de uma pessoa existente pelo seu ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dados da pessoa atualizados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização")
    })
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @Valid @RequestBody PessoaDTO pessoaDTO) {
        Optional<Pessoa> existingPessoa = pessoaService.findById(id);
        if (existingPessoa.isPresent()) {
            Pessoa pessoaToUpdate = pessoaService.convertToEntity(pessoaDTO);
            pessoaToUpdate.setId(id);  // Asegura que a entidade a ser atualizada é a correta
            Pessoa updatedPessoa = pessoaService.save(pessoaToUpdate);
            return ResponseEntity.ok(updatedPessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma pessoa", description = "Remove uma pessoa do sistema pelo seu ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pessoa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isPresent()) {
            pessoaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
