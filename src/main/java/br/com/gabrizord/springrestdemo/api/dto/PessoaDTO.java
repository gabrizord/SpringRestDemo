package br.com.gabrizord.springrestdemo.api.dto;

import br.com.gabrizord.springrestdemo.domain.entities.Pessoa;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public abstract class PessoaDTO {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public abstract Pessoa toEntity();
}
