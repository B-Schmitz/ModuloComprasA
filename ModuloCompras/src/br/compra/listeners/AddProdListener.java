
package br.compra.listeners;

import br.compra.telas.AddProdutoRequisicao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddProdListener implements ActionListener{

    AddProdutoRequisicao  Addprod;
    
    public AddProdListener(AddProdutoRequisicao  Addprod) {
        
        this.Addprod = Addprod;
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Adicionar")) {
            
            Addprod.AddRequisicao();
            
        }
        
        if (e.getActionCommand().equals("Remover")) {
            Addprod.RemoveRequisicao();
        }
        
        if (e.getActionCommand().equals("Finalizar")) {
          
            Addprod.Finaliza();
            Addprod.dispose();
            
        }
    }
    
}
