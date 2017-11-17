
package br.compra.getset;

import java.util.List;


public class MovimetoGetSet {
    
    
    private Integer idMovimento;
    private String data;
    
    private List<MovimentoItem> lisItem;

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<MovimentoItem> getLisItem() {
        return lisItem;
    }

    public void setLisItem(List<MovimentoItem> lisItem) {
        this.lisItem = lisItem;
    }
    
}
