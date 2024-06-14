package br.com.gabrizord.springrestdemo.dtos;

import br.com.gabrizord.springrestdemo.entities.PessoaFisica;
import jakarta.validation.constraints.Size;

public class PessoaFisicaDTO extends PessoaDTO {

    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    private String cpf;

    @Size(max = 20, message = "RG não pode ter mais de 20 caracteres")
    private String rg;

    public PessoaFisica toEntity() {
        return new PessoaFisica(
                this.getNome(),
                this.getEndereco(),
                this.getEmail(),
                this.getTelefone(),
                this.getCpf(),
                this.getRg()
        );
    }

    public @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres") String getCpf() {
        return cpf;
    }

    public void setCpf(@Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres") String cpf) {
        this.cpf = cpf;
    }

    public @Size(max = 20, message = "RG não pode ter mais de 20 caracteres") String getRg() {
        return rg;
    }

    public void setRg(@Size(max = 20, message = "RG não pode ter mais de 20 caracteres") String rg) {
        this.rg = rg;
    }
}
