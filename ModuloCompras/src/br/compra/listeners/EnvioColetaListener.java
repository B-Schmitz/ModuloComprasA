package br.compra.listeners;

import br.compra.getset.RequisicaoGetSet;
import br.compra.telas.EnvioColetaDePreco;
import br.compra.xls.GerarXls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvioColetaListener implements ActionListener {

    private RequisicaoGetSet req;
    private GerarXls xls;

    private final EnvioColetaDePreco coleta;

    public EnvioColetaListener(EnvioColetaDePreco coleta) {

        this.coleta = coleta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Enviar")) {
            req = coleta.getColeta();
            xls = new GerarXls(req);
            new Thread(() -> {

                xls.geraxls();
            }).start();

        }
        if (e.getActionCommand().equals("Cancelar")) {

            coleta.dispose();
        }
    }
}
