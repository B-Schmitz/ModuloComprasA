
package br.compra.getset;


public class ColetaGetSet {
    
    private Integer codigoColeta, codigoColetaItem, quantidade;
    private String data,dataPrevista;
    private Double valorEstimado, preco_unitario;
    private ProdutoGetSet p;
    private FornecedorGetSet f;

    public Integer getCodigoColeta() {
        return codigoColeta;
    }

    public void setCodigoColeta(Integer codigoColeta) {
        this.codigoColeta = codigoColeta;
    }

    public Integer getCodigoColetaItem() {
        return codigoColetaItem;
    }

    public void setCodigoColetaItem(Integer codigoColetaItem) {
        this.codigoColetaItem = codigoColetaItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }



    public Double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(Double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }
   

   

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(Double valorEstimado) {
        this.valorEstimado = valorEstimado;
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
