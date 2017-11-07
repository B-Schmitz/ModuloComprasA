package br.compra.listeners;

import br.compra.dao.PedidoDao;
import br.compra.getset.PedidoGetSet;
import br.compra.telas.PedidoCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PedidoListener implements ActionListener {

    private final PedidoCompra pedido;
    private PedidoGetSet ped;
    private final PedidoDao pedDao = new PedidoDao();

    public PedidoListener(PedidoCompra pedido) {
        this.pedido = pedido;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Editar")) {

            pedido.editar();

        }
        if (e.getActionCommand().equals("Excluir")) {

            pedido.remove();

        }
        if (e.getActionCommand().equals("Cadastar")) {

            if (pedido.Verifica()) {
                ped = pedido.getPedido();
                pedDao.Insert(ped);
                pedido.Limpar();
                try {
                    pedido.AtualizaCodigo();
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro concluído", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/icones/add.png"));
            } else {
                JOptionPane.showMessageDialog(null, "Tabela produtos solicitados vazia", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
            }
        }
    }
}
