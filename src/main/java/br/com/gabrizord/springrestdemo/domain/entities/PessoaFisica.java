package br.com.gabrizord.springrestdemo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String rg;

    public PessoaFisica(String nome, String endereco, String email, String telefone,
                        String cpf, String rg) {
        super(nome, endereco, email, telefone);
        this.cpf = cpf;
        this.rg = rg;
    }
}