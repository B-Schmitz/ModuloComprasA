package br.compra.listeners;

import br.compra.dao.CategoriaDao;
import br.compra.dao.ProdutoDao;
import br.compra.getset.CategoriaGetSet;
import br.compra.getset.ProdutoGetSet;
import br.compra.telas.CadastrarProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ProdutoListener implements ActionListener {

    private final CadastrarProduto Cadastroproduto;
    private ProdutoGetSet produto;
    private final ProdutoDao produtoDao = new ProdutoDao();
    private final CategoriaDao catDao = new CategoriaDao();
    private List<CategoriaGetSet> lis = new ArrayList<>();

    public ProdutoListener(CadastrarProduto cadastrarProduto) {
        lis.clear();

        this.Cadastroproduto = cadastrarProduto;
        lis = catDao.read(lis);
        cadastrarProduto.setComboBox(lis);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // CADASTRO DE PRODUTO
        if (e.getActionCommand().equals("Cadastrar")) {

            if (Cadastroproduto.Verifica()) {
                produto = Cadastroproduto.getproduto();
                int id = catDao.buscaCat(produto.getCat().getNome());
                try {
                    if (!produtoDao.isRegistro(produto)) {
                        produto.getCat().setCodigo(id);
                        produtoDao.Insert(produto);
                        Cadastroproduto.Limpar();
                        Cadastroproduto.NormalizaTexto();
                        Cadastroproduto.AtualizaCodigo();
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro concluído", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/icones/add.png"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome de produto já cadastrado", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                        if (Cadastroproduto.UpdateProduto()) {
                            produto = Cadastroproduto.getproduto();
                            produtoDao.Update(produto);
                            Cadastroproduto.Limpar();
                            Cadastroproduto.NormalizaTexto();
                            JOptionPane.showMessageDialog(null, "Saldo do produto atualizado com sucesso", "Atualização concluída", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/icones/add.png"));
                        }
                    }
                } catch (SQLException | InterruptedException ex) {
                    Logger.getLogger(ProdutoListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para efetuar o cadastro", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
            }
        }

        if (e.getActionCommand().equals("Limpar")) {
            Cadastroproduto.Limpar();

        }
        if (e.getActionCommand().equals("Novo")) {
            String novaCategoria = JOptionPane.showInputDialog("Informe a nova categoria");
            catDao.Insert(novaCategoria);
            lis.clear();
            lis = catDao.read(lis);
            Cadastroproduto.setComboBox(lis);
        }

        if (e.getActionCommand().equals("Alterar saldo")) {
            Cadastroproduto.JanelaAlterarSaldo();
        }
    }

}
