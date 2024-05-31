package br.com.gabrizord.bmbackend.entities;

import br.com.gabrizord.bmbackend.enums.TipoPessoa;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@DiscriminatorValue("J")
public class PessoaJuridica extends Pessoa {

    @NotBlank(message = "CNPJ é obrigatório")
    @Size(min = 14, max = 20, message = "CNPJ deve ter entre 14 e 20 caracteres")
    @Column(length = 20)
    private String cnpj;

    @Size(max = 20, message = "Inscrição Estadual não pode ter mais de 20 caracteres")
    @Column(length = 20)
    private String inscricaoEstadual;

    @Size(max = 20, message = "Inscrição Municipal não pode ter mais de 20 caracteres")
    @Column(length = 20)
    private String inscricaoMunicipal;

    @Size(max = 50, message = "País não pode ter mais de 50 caracteres")
    @Column(length = 50)
    private String pais;

    @Size(max = 20, message = "Regime Tributário não pode ter mais de 20 caracteres")
    @Column(length = 20)
    private String regimeTributario;

    @Size(max = 100, message = "Natureza Jurídica não pode ter mais de 100 caracteres")
    @Column(length = 100)
    private String naturezaJuridica;

    @Size(max = 20, message = "Código de Atividade não pode ter mais de 20 caracteres")
    @Column(length = 20)
    private String codigoAtividade;

    @Size(max = 255, message = "Responsável não pode ter mais de 255 caracteres")
    @Column(length = 255)
    private String responsavel;

    @Size(min = 11, max = 14, message = "CPF do Responsável deve ter entre 11 e 14 caracteres")
    @Column(length = 14)
    private String cpfResponsavel;

    @Size(max = 20, message = "Situação Cadastral não pode ter mais de 20 caracteres")
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
