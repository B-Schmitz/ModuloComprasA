package br.compra.listeners;

import br.compra.dao.RequisicaoDao;
import br.compra.getset.RequisicaoGetSet;
import br.compra.telas.RequisicaoCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RequisicaoListener implements ActionListener {

    private final RequisicaoCompra requisicao;
    private RequisicaoGetSet req;
    private final RequisicaoDao reqDao = new RequisicaoDao();

    public RequisicaoListener(RequisicaoCompra requisicao) {

        this.requisicao = requisicao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Cadastrar")) {

            if (requisicao.Verifica()) {
                req = requisicao.getRequisicao();
                try {
                    if (!reqDao.isRegistro(req)) {
                        req = requisicao.getRequisicao();
                        reqDao.Insert(req);
                        requisicao.Limpar();
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro concluído", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/icones/add.png"));
                        requisicao.AtualizaCodigo();
                    } else {
                        JOptionPane.showMessageDialog(null, "ID de requisição já cadastrado", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RequisicaoListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para efetuar o cadastro", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
            }
        }

        if (e.getActionCommand().equals("Inserir")) {
            requisicao.AbreJanelaAdd();
        }

        if (e.getActionCommand().equals("Excluir")) {
            requisicao.Remove();
        }

        if (e.getActionCommand().equals("Limpar")) {
            requisicao.Limpar();
        }

    }
}
