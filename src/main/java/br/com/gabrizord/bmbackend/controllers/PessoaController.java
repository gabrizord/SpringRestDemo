package br.com.gabrizord.bmbackend.controllers;

import br.com.gabrizord.bmbackend.dtos.PessoaFisicaDTO;
import br.com.gabrizord.bmbackend.dtos.PessoaJuridicaDTO;
import br.com.gabrizord.bmbackend.entities.Pessoa;
import br.com.gabrizord.bmbackend.dtos.PessoaDTO;
import br.com.gabrizord.bmbackend.services.PessoaService;
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
    public List<Pessoa> getAllPessoas() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
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
