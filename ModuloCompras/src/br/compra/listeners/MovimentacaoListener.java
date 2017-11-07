package br.compra.listeners;

import br.compra.getset.MovimentacaoGetSet;
import br.compra.telas.MovimentacaoCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovimentacaoListener implements ActionListener{
    
    private final MovimentacaoCompra movimentacao;
    private MovimentacaoGetSet mov;

    public MovimentacaoListener(MovimentacaoCompra movimentacao) {

        this.movimentacao = movimentacao;
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Cadastrar")) {

      
            mov = movimentacao.getMovimentacao();

            System.out.println(mov.toString());

        }

    }

}
