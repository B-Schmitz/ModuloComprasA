package br.compra.getset;

import java.util.List;

public class PedidoGetSet {

    private Integer idPedidoCompra;
    private String Data;
    private double valor_estimado;
    private List<PedidoItemGetSet> pItem;

    public List<PedidoItemGetSet> getpItem() {
        return pItem;
    }

    public void setpItem(List<PedidoItemGetSet> pItem) {
        this.pItem = pItem;
    }

    public Integer getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(Integer idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public double getValor_estimado() {
        return valor_estimado;
    }

    public void setValor_estimado(double valor_estimado) {
        this.valor_estimado = valor_estimado;
    }
 

    
    
    
}
