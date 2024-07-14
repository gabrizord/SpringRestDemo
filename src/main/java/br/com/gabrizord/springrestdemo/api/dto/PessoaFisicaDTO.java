package br.com.gabrizord.springrestdemo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaFisicaDTO extends PessoaDTO {

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    private String cpf;

    @NotBlank(message = "RG é obrigatório")
    @Size(max = 20, message = "RG não pode ter mais de 20 caracteres")
    private String rg;

}
