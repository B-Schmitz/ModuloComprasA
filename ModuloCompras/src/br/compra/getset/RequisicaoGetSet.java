package br.compra.getset;

import java.util.List;

public class RequisicaoGetSet {

    private String Solicitante, Chefe, Data, Setor, Observacoes, Prioridade;
    private Integer NumRequisicao;
    private List<String> Codigo_produto;
    private List<String> Quantidade;
    private List<ProdutoGetSet> lisproduto;

    public List<String> getCodigo_produto() {
        return Codigo_produto;
    }

    public void setCodigo_produto(List<String> Codigo_produto) {
        this.Codigo_produto = Codigo_produto;
    }

    public List<ProdutoGetSet> getLisproduto() {
        return lisproduto;
    }

    public void setLisproduto(List<ProdutoGetSet> lisproduto) {
        this.lisproduto = lisproduto;
    }
  

    public List<String> getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(List<String> Quantidade) {
        this.Quantidade = Quantidade;
    }

    public List<String> getProduto() {
        return Codigo_produto;
    }

    public void setProduto(List<String> produto) {
        this.Codigo_produto = produto;
    }

  

    public String getPrioridade() {
        return Prioridade;
    }

    public void setPrioridade(String Prioridade) {
        this.Prioridade = Prioridade;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    public String getSolicitante() {
        return Solicitante;
    }

    public void setSolicitante(String Solicitante) {
        this.Solicitante = Solicitante;
    }

    public String getChefe() {
        return Chefe;
    }

    public void setChefe(String Chefe) {
        this.Chefe = Chefe;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    public Integer getNumRequisicao() {
        return NumRequisicao;
    }

    public void setNumRequisicao(Integer NumRequisicao) {
        this.NumRequisicao = NumRequisicao;
    }

    @Override
    public String toString() {
        return "RequisicaoGetSet{" + "\nSolicitante: " + Solicitante + "\n Chefe: " + Chefe + "\n Data: " + Data + "\n Setor: " + Setor + "\n Observacoes: " + Observacoes + "\n Prioridade: " + Prioridade + "\n NumRequisicao: " + NumRequisicao + "\n}";
    }

}
