package br.com.gabrizord.springrestdemo.api.dto;

import br.com.gabrizord.springrestdemo.domain.entities.PessoaJuridica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PessoaJuridicaDTO extends PessoaDTO {

    @NotBlank(message = "CNPJ é obrigatório")
    @Size(min = 14, max = 20, message = "CNPJ deve ter entre 14 e 20 caracteres")
    private String cnpj;

    @NotBlank(message = "Inscrição Estadual é obrigatório")
    @Size(max = 20, message = "Inscrição Estadual não pode ter mais de 20 caracteres")
    private String inscricaoEstadual;

    @NotBlank(message = "Inscrição Municipal é obrigatório")
    @Size(max = 20, message = "Inscrição Municipal não pode ter mais de 20 caracteres")
    private String inscricaoMunicipal;

    @NotBlank(message = "Pais é obrigatório")
    @Size(max = 50, message = "Pais não pode ter mais de 50 caracteres")
    private String pais;

    @NotBlank(message = "Regime Tributário é obrigatório")
    @Size(max = 20, message = "Regime Tributário não pode ter mais de 20 caracteres")
    private String regimeTributario;

    @NotBlank(message = "Natureza Jurídica é obrigatório")
    @Size(max = 100, message = "Natureza Jurídica não pode ter mais de 100 caracteres")
    private String naturezaJuridica;

    @NotBlank(message = "Código de Atividade é obrigatório")
    @Size(max = 20, message = "Código de Atividade não pode ter mais de 20 caracteres")
    private String codigoAtividade;

    @NotBlank(message = "Responsável é obrigatório")
    @Size(max = 255, message = "Responsável não pode ter mais de 255 caracteres")
    private String responsavel;

    @NotBlank(message = "CPF do Responsável é obrigatório")
    @Size(min = 11, max = 14, message = "CPF do Responsável deve ter entre 11 e 14 caracteres")
    private String cpfResponsavel;

    @NotBlank(message = "Situação Cadastral é obrigatório")
    @Size(max = 20, message = "Situação Cadastral não pode ter mais de 20 caracteres")
    private String situacaoCadastral;

    @Override
    public PessoaJuridica toEntity() {
        return new PessoaJuridica(
                this.getNome(),
                this.getEndereco(),
                this.getEmail(),
                this.getTelefone(),
                this.getCnpj(),
                this.getInscricaoEstadual(),
                this.getInscricaoMunicipal(),
                this.getPais(),
                this.getRegimeTributario(),
                this.getNaturezaJuridica(),
                this.getCodigoAtividade(),
                this.getResponsavel(),
                this.getCpfResponsavel(),
                this.getSituacaoCadastral()
        );
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
