
package br.compra.getset;


public class NotaItemGetSet {
    
    
     private Integer idNotaFiscal_Item,quantidade,idProduto,idNotaFiscal,idFornecedor;
     private Double preco;
     private ProdutoGetSet p;
     private FornecedorGetSet f;

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

    public Integer getIdNotaFiscal_Item() {
        return idNotaFiscal_Item;
    }

    public void setIdNotaFiscal_Item(Integer idNotaFiscal_Item) {
        this.idNotaFiscal_Item = idNotaFiscal_Item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
}
