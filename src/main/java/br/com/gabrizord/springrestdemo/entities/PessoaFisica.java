package br.com.gabrizord.springrestdemo.entities;

import br.com.gabrizord.springrestdemo.enums.TipoPessoa;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    @Column(length = 14)
    private String cpf;

    @Size(max = 20, message = "RG não pode ter mais de 20 caracteres")
    @Column(length = 20)
    private String rg;

    public PessoaFisica() {
        super();
        setTipoPessoa(TipoPessoa.F);
    }

    public PessoaFisica(String nome, String endereco, String email, String telefone,
                        String cpf, String rg) {
        super(nome, endereco, email, telefone);
        this.cpf = cpf;
        this.rg = rg;
        setTipoPessoa(TipoPessoa.F);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}