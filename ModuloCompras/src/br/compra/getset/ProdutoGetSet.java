package br.compra.getset;

import java.util.List;

public class ProdutoGetSet {

    private String codigo, nome, data, quant;
    private int saldo, est_max, est_min;
    private float preco_un, preco_compra, preco_venda, preco_custo;
    private CategoriaGetSet cat;


    public List<FornecedorGetSet> getF() {
        return f;
    }

    public void setF(List<FornecedorGetSet> f) {
        this.f = f;
    }
    private List<FornecedorGetSet> f;

    public CategoriaGetSet getCat() {
        return cat;
    }

    public void setCat(CategoriaGetSet cat) {
        this.cat = cat;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getquant() {
        return quant;
    }

    public void setquant(String quant) {
        this.quant = quant;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getEst_max() {
        return est_max;
    }

    public void setEst_max(int est_max) {
        this.est_max = est_max;
    }

    public int getEst_min() {
        return est_min;
    }

    public void setEst_min(int est_min) {
        this.est_min = est_min;
    }

    public float getPreco_un() {
        return preco_un;
    }

    public void setPreco_un(float preco_un) {
        this.preco_un = preco_un;
    }

    public float getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }
    
     public float getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(float preco_custo) {
        this.preco_custo = preco_custo;
    }
    

}
