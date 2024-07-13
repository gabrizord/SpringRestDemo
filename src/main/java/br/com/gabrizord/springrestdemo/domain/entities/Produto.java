package br.com.gabrizord.springrestdemo.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;


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

    @Column(length = 2)
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

    public Produto(){

    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getBaseCalculoIcms() {
        return baseCalculoIcms;
    }

    public void setBaseCalculoIcms(BigDecimal baseCalculoIcms) {
        this.baseCalculoIcms = baseCalculoIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(BigDecimal aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }
}
