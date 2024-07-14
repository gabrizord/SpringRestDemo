package br.com.gabrizord.springrestdemo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Setter
@Getter
public class ProdutoDTO {

    @NotBlank(message = "Código é obrigatório")
    @Size(max = 50, message = "Código não pode ter mais de 50 caracteres")
    private String codigo;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 50, message = "Nome não pode ter mais de 50 caracteres")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 255, message = "Descrição não pode ter mais de 255 caracteres")
    private String descricao;

    @NotBlank(message = "NCM é obrigatório")
    @Size(min = 8, max = 8, message = "NCM deve ter 8 caracteres")
    private String ncm;

    @NotBlank(message = "CST é obrigatório")
    @Size(max = 3, message = "CST não pode ter mais de 3 caracteres")
    private String cst;

    @NotBlank(message = "CFOP é obrigatório")
    @Size(max = 4, message = "CFOP não pode ter mais de 4 caracteres")
    private String cfop;

    @NotBlank(message = "Unidade é obrigatória")
    @Length(max = 6, message = "Unidade não pode ter mais de 6 caracteres")
    private String unidade;

    @NotNull(message = "Quantidade é obrigatória")
    @PositiveOrZero(message = "Quantidade deve ser positiva")
    private BigDecimal quantidade;

    @NotNull(message = "Valor Unitário é obrigatório")
    @PositiveOrZero(message = "Valor Unitário deve ser zero ou positivo")
    private BigDecimal valorUnitario;

    @NotNull(message = "Valor Total é obrigatório")
    @PositiveOrZero(message = "Valor Total deve ser zero ou positivo")
    private BigDecimal valorTotal;

    @NotNull(message = "Base de Cálculo do ICMS é obrigatória")
    @PositiveOrZero(message = "Base de Cálculo do ICMS deve ser zero ou positiva")
    private BigDecimal baseCalculoIcms;

    @NotNull(message = "Valor do ICMS é obrigatório")
    @PositiveOrZero(message = "Valor do ICMS deve ser zero ou positivo")
    private BigDecimal valorIcms;

    @NotNull(message = "Alíquota do ICMS é obrigatória")
    @PositiveOrZero(message = "Alíquota do ICMS deve ser zero ou positiva")
    private BigDecimal aliquotaIcms;

    @NotBlank(message = "Informações Adicionais é obrigatório")
    @Size(max = 500, message = "Informações Adicionais não podem ter mais de 500 caracteres")
    private String informacoesAdicionais;

}
