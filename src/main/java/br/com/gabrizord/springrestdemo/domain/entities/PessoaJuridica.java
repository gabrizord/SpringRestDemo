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
public class PessoaJuridica extends Pessoa {

    @Column(length = 20)
    private String cnpj;

    @Column(length = 20)
    private String inscricaoEstadual;

    @Column(length = 20)
    private String inscricaoMunicipal;

    @Column(length = 50)
    private String pais;

    @Column(length = 20)
    private String regimeTributario;

    @Column(length = 100)
    private String naturezaJuridica;

    @Column(length = 20)
    private String codigoAtividade;

    @Column()
    private String responsavel;

    @Column(length = 14)
    private String cpfResponsavel;

    @Column(length = 20)
    private String situacaoCadastral;

    public PessoaJuridica(String nome, String endereco, String email, String telefone,
                          String cnpj, String inscricaoEstadual, String inscricaoMunicipal, String pais,
                          String regimeTributario, String naturezaJuridica, String codigoAtividade,
                          String responsavel, String cpfResponsavel, String situacaoCadastral) {
        super(nome, endereco, email, telefone);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.pais = pais;
        this.regimeTributario = regimeTributario;
        this.naturezaJuridica = naturezaJuridica;
        this.codigoAtividade = codigoAtividade;
        this.responsavel = responsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.situacaoCadastral = situacaoCadastral;
    }

}
