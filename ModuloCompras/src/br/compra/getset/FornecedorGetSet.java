package br.compra.getset;

import java.util.ArrayList;
import java.util.List;

public class FornecedorGetSet {

    // Depois muda o tipo de variável
    private String Codigo, CNPJ, Nome, Email, Telefone;
    private EnderecoGetSet e;
    private List<ProdutoGetSet> p = new ArrayList<>();
    private CategoriaGetSet cat;

    public List<ProdutoGetSet> getP() {
        return p;
    }

    public void setP(ProdutoGetSet p) {
        this.p.add(p);
    }

    public CategoriaGetSet getCat() {
        return cat;
    }

    public void setCat(CategoriaGetSet cat) {
        this.cat = cat;
    }
  

    public EnderecoGetSet getE() {
        return e;
    }

    public void setE(EnderecoGetSet e) {
        this.e = e;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

}
