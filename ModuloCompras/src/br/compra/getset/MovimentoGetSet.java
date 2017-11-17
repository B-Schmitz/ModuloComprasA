
package br.compra.getset;

import java.util.List;


public class MovimentoGetSet {
    
    
    private Integer idMovimento;
    private String Data;
    private List<MovimentoItemGetSet> lisMovimento;

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public List<MovimentoItemGetSet> getLisMovimento() {
        return lisMovimento;
    }

    public void setLisMovimento(List<MovimentoItemGetSet> lisMovimento) {
        this.lisMovimento = lisMovimento;
    }
    
}
