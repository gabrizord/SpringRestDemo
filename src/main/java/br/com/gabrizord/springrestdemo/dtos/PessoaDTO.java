package br.com.gabrizord.springrestdemo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PessoaDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 255, message = "Nome não pode ter mais de 255 caracteres")
    private String nome;

    @Size(max = 50, message = "Endereço não pode ter mais de 50 caracteres")
    private String endereco;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser um endereço de e-mail válido")
    @Size(max = 50, message = "Email não pode ter mais de 50 caracteres")
    private String email;

    @Size(max = 15, message = "Telefone não pode ter mais de 15 caracteres")
    private String telefone;

    @Size(max = 50, message = "País não pode ter mais de 50 caracteres")
    private String pais;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório") @Size(max = 255, message = "Nome não pode ter mais de 255 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") @Size(max = 255, message = "Nome não pode ter mais de 255 caracteres") String nome) {
        this.nome = nome;
    }

    public @Size(max = 50, message = "Endereço não pode ter mais de 50 caracteres") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@Size(max = 50, message = "Endereço não pode ter mais de 50 caracteres") String endereco) {
        this.endereco = endereco;
    }

    public @NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser um endereço de e-mail válido") @Size(max = 50, message = "Email não pode ter mais de 50 caracteres") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Email(message = "Email deve ser um endereço de e-mail válido") @Size(max = 50, message = "Email não pode ter mais de 50 caracteres") String email) {
        this.email = email;
    }

    public @Size(max = 15, message = "Telefone não pode ter mais de 15 caracteres") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Size(max = 15, message = "Telefone não pode ter mais de 15 caracteres") String telefone) {
        this.telefone = telefone;
    }

    public @Size(max = 50, message = "País não pode ter mais de 50 caracteres") String getPais() {
        return pais;
    }

    public void setPais(@Size(max = 50, message = "País não pode ter mais de 50 caracteres") String pais) {
        this.pais = pais;
    }
}
