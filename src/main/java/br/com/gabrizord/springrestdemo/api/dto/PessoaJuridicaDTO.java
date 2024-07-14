package br.com.gabrizord.springrestdemo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
