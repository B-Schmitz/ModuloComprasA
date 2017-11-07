
package br.compra.listeners;

import br.compra.telas.ConsultarRequisicao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConsultaReqListener implements ActionListener{

    ConsultarRequisicao consulta;
    public ConsultaReqListener(ConsultarRequisicao  consulta) {
        
        this.consulta = consulta;
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Aprovar")){
            
            consulta.inicia();
            
        }
         if(e.getActionCommand().equals("Reprovar")){
            consulta.reprovar();
        }
        
    }
    
}
