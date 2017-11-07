package br.compra.getset;

public class MovimentacaoGetSet {
    
    private String data;
    private Integer NumMovimentacao;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getNumMovimentacao() {
        return NumMovimentacao;
    }

    public void setNumMovimentacao(Integer codigo) {
        this.NumMovimentacao = codigo;
    }
    
    @Override
    public String toString() {
        return "MovimentacaoGetSet{" + "\nNumMovimentacao: " + NumMovimentacao + "\nData: " + data + "\n}";
    }

}
