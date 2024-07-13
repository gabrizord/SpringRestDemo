package br.com.gabrizord.springrestdemo.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PessoaDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 255, message = "Nome não pode ter mais de 255 caracteres")
    private String nome;

    @NotBlank(message = "Endereço é obrigatório")
    @Size(max = 50, message = "Endereço não pode ter mais de 50 caracteres")
    private String endereco;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser um endereço de e-mail válido")
    @Size(max = 50, message = "Email não pode ter mais de 50 caracteres")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(max = 15, message = "Telefone não pode ter mais de 15 caracteres")
    private String telefone;

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

}
