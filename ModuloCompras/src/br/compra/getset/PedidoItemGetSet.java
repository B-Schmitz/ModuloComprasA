
package br.compra.getset;


public class PedidoItemGetSet {
    
    private Integer idPedidoCompraItem,quantidade,idPedidoCompra;
    private String dataPrevista;

    public Integer getIdPedidoCompraItem() {
        return idPedidoCompraItem;
    }

    public void setIdPedidoCompraItem(Integer idPedidoCompraItem) {
        this.idPedidoCompraItem = idPedidoCompraItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(Integer idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
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
    private Double preco;
    private ProdutoGetSet p;

    
    
}
