package br.compra.listeners;

import br.compra.telas.AlterarSaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AlterarSaldoListener implements ActionListener {

    AlterarSaldo alterarSaldo;

    public AlterarSaldoListener(AlterarSaldo alterarSaldo) {

        this.alterarSaldo = alterarSaldo;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Alterar Saldo")) {
            alterarSaldo.Alterar();
            JOptionPane.showMessageDialog(null, "Saldo do produto atualizado com sucesso", "Atualização concluída", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/icones/add.png"));
        }

    }

}
