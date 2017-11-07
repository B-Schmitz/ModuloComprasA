
package br.compra.listeners;

import br.compra.dao.PedidoDao;
import br.compra.getset.PedidoGetSet;
import br.compra.telas.VisualizarPedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarPedidosListener implements ActionListener{
    
    private VisualizarPedidos visualizarp;
    private PedidoDao pDao = new PedidoDao();
    private PedidoGetSet p;
    

    public ConsultarPedidosListener(VisualizarPedidos visualizarp) {
        this.visualizarp = visualizarp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Dar baixa")){
            p = visualizarp.Baixa();
            pDao.Delete(p);
            visualizarp.AtualizaTabela();
            
            
            
            
        }
        
    }
    
}
