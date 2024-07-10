package br.com.gabrizord.springrestdemo.dtos;

import br.com.gabrizord.springrestdemo.entities.PessoaJuridica;
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
}
