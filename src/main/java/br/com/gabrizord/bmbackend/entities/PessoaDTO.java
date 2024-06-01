package br.com.gabrizord.bmbackend.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PessoaDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 255, message = "Nome não pode ter mais de 255 caracteres")
    private String nome;

    @Size(max = 50, message = "Endereço não pode ter mais de 50 caracteres")
    private String endereco;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser um endereço de e-mail válido")
    @Size(max = 50, message = "Email não pode ter mais de 50 caracteres")
    private String email;

    @Size(max = 15, message = "Telefone não pode ter mais de 15 caracteres")
    private String telefone;

    @NotBlank(message = "Tipo de pessoa é obrigatório")
    private String tipoPessoa;

    // Campos específicos para PessoaFisica
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    private String cpf;

    @Size(max = 20, message = "RG não pode ter mais de 20 caracteres")
    private String rg;

    // Campos específicos para PessoaJuridica
    @Size(min = 14, max = 20, message = "CNPJ deve ter entre 14 e 20 caracteres")
    private String cnpj;

    @Size(max = 20, message = "Inscrição Estadual não pode ter mais de 20 caracteres")
    private String inscricaoEstadual;

    @Size(max = 20, message = "Inscrição Municipal não pode ter mais de 20 caracteres")
    private String inscricaoMunicipal;

    @Size(max = 50, message = "País não pode ter mais de 50 caracteres")
    private String pais;

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

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
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
