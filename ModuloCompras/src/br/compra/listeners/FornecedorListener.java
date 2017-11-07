package br.compra.listeners;

import br.compra.dao.CategoriaDao;
import br.compra.dao.Enderecodao;
import br.compra.dao.FornecedorDao;
import br.compra.getset.CategoriaGetSet;
import br.compra.getset.EnderecoGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.telas.CadastrarFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FornecedorListener implements ActionListener {
    
    private final CadastrarFornecedor fornecedor;
    private FornecedorGetSet forn;
    private final FornecedorDao fornDao = new FornecedorDao();
    private EnderecoGetSet end;
    private final Enderecodao endDao = new Enderecodao();
    private List<CategoriaGetSet> lis = new ArrayList<>();
    private final CategoriaDao catDao = new CategoriaDao();
    
    public FornecedorListener(CadastrarFornecedor fornecedor) {
        this.fornecedor = fornecedor;
        lis = catDao.read(lis);
        fornecedor.setComboBox(lis);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Cadastrar")) {
            
            if (fornecedor.Verifica()) {
                forn = fornecedor.getfornecedor();
                int id = catDao.buscaCat(forn.getCat().getNome());
                
                try {
                    if (!fornDao.isRegistro(forn)) {
                        forn.getCat().setCodigo(id);
                        end = endDao.Insert(forn.getE());
                        forn.setE(end);
                        fornDao.Insert(forn);
                        fornecedor.Limpar();
                        fornecedor.AtualizaCodigo();
                        fornecedor.NormalizaTexto();
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro concluído", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/icones/add.png"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome de fornecedor ou CNPJ já cadastrado", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                        fornecedor.AlertaTexto();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FornecedorListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para efetuar o cadastro", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
            }
        }
        
        if (e.getActionCommand().equals("Limpar")) {
            
            fornecedor.Limpar();
            
        }
        
         if (e.getActionCommand().equals("Novo")) {
             
            String novaCategoria = JOptionPane.showInputDialog("Informe a nova categoria");
            catDao.Insert(novaCategoria);
            lis.clear();
            lis = catDao.read(lis);
            fornecedor.setComboBox(lis);
        }
    }
}
