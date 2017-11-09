package br.compra.getset;

import java.util.List;

public class NotaGetSet {

    private Integer idVeiculo;
    private String modelo, marca, placa;
    private Integer idTransportador, numeracao, codigo_antt;
    private float peso_bruto, peso_liquido;
    private Double frete, valorSeguro;
    private String nome, especie;
    private Integer idNotaFiscal, numero, baseDeCalculoDo_ICMS, baseDeCalculoDo_ICMS_ST;
    private String data_emissao;

    private Double valorDo_ICMS, valorDo_ICMS_substituicao;
    private Integer idEndereco;
    private List<NotaItemGetSet> lisNotaItem;

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getIdTransportador() {
        return idTransportador;
    }

    public void setIdTransportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    public Integer getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(Integer numeracao) {
        this.numeracao = numeracao;
    }

    public float getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(float peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

    public float getPeso_liquido() {
        return peso_liquido;
    }

    public void setPeso_liquido(float peso_liquido) {
        this.peso_liquido = peso_liquido;
    }

    public Integer getCodigo_antt() {
        return codigo_antt;
    }

    public void setCodigo_antt(Integer codigo_antt) {
        this.codigo_antt = codigo_antt;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public Double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(Double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getBaseDeCalculoDo_ICMS() {
        return baseDeCalculoDo_ICMS;
    }

    public void setBaseDeCalculoDo_ICMS(Integer baseDeCalculoDo_ICMS) {
        this.baseDeCalculoDo_ICMS = baseDeCalculoDo_ICMS;
    }

    public Integer getBaseDeCalculoDo_ICMS_ST() {
        return baseDeCalculoDo_ICMS_ST;
    }

    public void setBaseDeCalculoDo_ICMS_ST(Integer baseDeCalculoDo_ICMS_ST) {
        this.baseDeCalculoDo_ICMS_ST = baseDeCalculoDo_ICMS_ST;
    }

    public Double getValorDo_ICMS() {
        return valorDo_ICMS;
    }

    public void setValorDo_ICMS(Double valorDo_ICMS) {
        this.valorDo_ICMS = valorDo_ICMS;
    }

    public Double getValorDo_ICMS_substituicao() {
        return valorDo_ICMS_substituicao;
    }

    public void setValorDo_ICMS_substituicao(Double valorDo_ICMS_substituicao) {
        this.valorDo_ICMS_substituicao = valorDo_ICMS_substituicao;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public List<NotaItemGetSet> getLisNotaItem() {
        return lisNotaItem;
    }

    public void setLisNotaItem(List<NotaItemGetSet> lisNotaItem) {
        this.lisNotaItem = lisNotaItem;
    }

}
