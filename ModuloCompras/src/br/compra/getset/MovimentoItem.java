package br.compra.getset;

public class MovimentoItem {

    private Integer idMovimentoItem, quant;
    private Double preco;
    private String Data;

    private ProdutoGetSet p;
    private FornecedorGetSet f;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public Integer getIdMovimentoItem() {
        return idMovimentoItem;
    }

    public void setIdMovimentoItem(Integer idMovimentoItem) {
        this.idMovimentoItem = idMovimentoItem;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ProdutoGetSet getP() {
        return p;
    }

    public void setP(ProdutoGetSet p) {
        this.p = p;
    }

    public FornecedorGetSet getF() {
        return f;
    }

    public void setF(FornecedorGetSet f) {
        this.f = f;
    }

}
