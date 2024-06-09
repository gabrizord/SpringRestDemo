package br.com.gabrizord.bmbackend.dtos;

import jakarta.validation.constraints.Size;

public class PessoaJuridicaDTO extends PessoaDTO {

    @Size(min = 14, max = 20, message = "CNPJ deve ter entre 14 e 20 caracteres")
    private String cnpj;

    @Size(max = 20, message = "Inscrição Estadual não pode ter mais de 20 caracteres")
    private String inscricaoEstadual;

    @Size(max = 20, message = "Inscrição Municipal não pode ter mais de 20 caracteres")
    private String inscricaoMunicipal;

    @Size(max = 20, message = "Regime Tributário não pode ter mais de 20 caracteres")
    private String regimeTributario;

    @Size(max = 100, message = "Natureza Jurídica não pode ter mais de 100 caracteres")
    private String naturezaJuridica;

    @Size(max = 20, message = "Código de Atividade não pode ter mais de 20 caracteres")
    private String codigoAtividade;

    @Size(max = 255, message = "Responsável não pode ter mais de 255 caracteres")
    private String responsavel;

    @Size(min = 11, max = 14, message = "CPF do Responsável deve ter entre 11 e 14 caracteres")
    private String cpfResponsavel;

    @Size(max = 20, message = "Situação Cadastral não pode ter mais de 20 caracteres")
    private String situacaoCadastral;

    public @Size(min = 14, max = 20, message = "CNPJ deve ter entre 14 e 20 caracteres") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@Size(min = 14, max = 20, message = "CNPJ deve ter entre 14 e 20 caracteres") String cnpj) {
        this.cnpj = cnpj;
    }

    public @Size(max = 20, message = "Inscrição Estadual não pode ter mais de 20 caracteres") String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(@Size(max = 20, message = "Inscrição Estadual não pode ter mais de 20 caracteres") String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public @Size(max = 20, message = "Inscrição Municipal não pode ter mais de 20 caracteres") String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(@Size(max = 20, message = "Inscrição Municipal não pode ter mais de 20 caracteres") String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public @Size(max = 20, message = "Regime Tributário não pode ter mais de 20 caracteres") String getRegimeTributario() {
        return regimeTributario;
    }

    public void setRegimeTributario(@Size(max = 20, message = "Regime Tributário não pode ter mais de 20 caracteres") String regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public @Size(max = 100, message = "Natureza Jurídica não pode ter mais de 100 caracteres") String getNaturezaJuridica() {
        return naturezaJuridica;
    }

    public void setNaturezaJuridica(@Size(max = 100, message = "Natureza Jurídica não pode ter mais de 100 caracteres") String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    public @Size(max = 20, message = "Código de Atividade não pode ter mais de 20 caracteres") String getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(@Size(max = 20, message = "Código de Atividade não pode ter mais de 20 caracteres") String codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public @Size(max = 255, message = "Responsável não pode ter mais de 255 caracteres") String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(@Size(max = 255, message = "Responsável não pode ter mais de 255 caracteres") String responsavel) {
        this.responsavel = responsavel;
    }

    public @Size(min = 11, max = 14, message = "CPF do Responsável deve ter entre 11 e 14 caracteres") String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(@Size(min = 11, max = 14, message = "CPF do Responsável deve ter entre 11 e 14 caracteres") String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public @Size(max = 20, message = "Situação Cadastral não pode ter mais de 20 caracteres") String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(@Size(max = 20, message = "Situação Cadastral não pode ter mais de 20 caracteres") String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }
}
