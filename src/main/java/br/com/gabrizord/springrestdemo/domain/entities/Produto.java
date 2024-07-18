package br.com.gabrizord.springrestdemo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50, unique = true)
    private String codigo;

    @Column(length = 50)
    private String nome;

    @Column(length = 100)
    private String descricao;
    
    @Column(length = 8)
    private String ncm;

    @Column(length = 3)
    private String cst;

    @Column(length = 4)
    private String cfop;

    @Column(length = 6)
    private String unidade;

    @Column(length = 10)
    private BigDecimal quantidade;

    @Column(length = 10)
    private BigDecimal valorUnitario;

    @Column(length = 10)
    private BigDecimal valorTotal;

    @Column(length = 10)
    private BigDecimal baseCalculoIcms;

    @Column(length = 10)
    private BigDecimal valorIcms;

    @Column(length = 10)
    private BigDecimal aliquotaIcms;

    @Column(length = 500)
    private String informacoesAdicionais;

    public Produto(String codigo, String nome, String descricao, String ncm, String cst, String cfop, String unidade, BigDecimal quantidade, BigDecimal valorUnitario, BigDecimal valorTotal, BigDecimal baseCalculoIcms, BigDecimal valorIcms, BigDecimal aliquotaIcms, String informacoesAdicionais) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.ncm = ncm;
        this.cst = cst;
        this.cfop = cfop;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.baseCalculoIcms = baseCalculoIcms;
        this.valorIcms = valorIcms;
        this.aliquotaIcms = aliquotaIcms;
        this.informacoesAdicionais = informacoesAdicionais;
    }
}
