package br.com.gabrizord.bmbackend.entities;

import br.com.gabrizord.bmbackend.enums.TipoPessoa;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("J")
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

    @Column(length = 255)
    private String responsavel;

    @Column(length = 14)
    private String cpfResponsavel;

    @Column(length = 20)
    private String situacaoCadastral;

    public PessoaJuridica() {
        super();
        setTipoPessoa(TipoPessoa.J);
    }

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
        setTipoPessoa(TipoPessoa.J);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegimeTributario() {
        return regimeTributario;
    }

    public void setRegimeTributario(String regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public String getNaturezaJuridica() {
        return naturezaJuridica;
    }

    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(String codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }
}
