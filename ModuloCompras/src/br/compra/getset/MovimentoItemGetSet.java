
package br.compra.getset;


public class MovimentoItemGetSet {
    
    private Integer Quantidade,idMovimentacaoItem,idMovimentacao;
    private Double preco;
    
    private ProdutoGetSet p;
    private FornecedorGetSet f;

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Integer getIdMovimentacaoItem() {
        return idMovimentacaoItem;
    }

    public void setIdMovimentacaoItem(Integer idMovimentacaoItem) {
        this.idMovimentacaoItem = idMovimentacaoItem;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
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
