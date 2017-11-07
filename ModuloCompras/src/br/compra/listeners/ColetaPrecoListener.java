
package br.compra.listeners;

import br.compra.telas.ColetaDePreco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ColetaPrecoListener implements ActionListener{
private ColetaDePreco coleta;

    public ColetaPrecoListener(ColetaDePreco coleta) {
        this.coleta = coleta;
    }

 

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Buscar")){
            
            coleta.Abre();
       }
        
        if(e.getActionCommand().equals("Gerar pedido de compra")){
            
            coleta.geraPedido();
        }
        
    }


    
}
