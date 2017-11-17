
package br.compra.listeners;

import br.compra.dao.MovimentoDao;
import br.compra.dao.PedidoDao;
import br.compra.getset.MovimentacaoGetSet;
import br.compra.getset.PedidoGetSet;
import br.compra.telas.VisualizarPedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarPedidosListener implements ActionListener{
    
    private VisualizarPedidos visualizarp;
    private PedidoDao pDao = new PedidoDao();
    private MovimentoDao mDao = new MovimentoDao();
    private PedidoGetSet p;
    

    public ConsultarPedidosListener(VisualizarPedidos visualizarp) {
        this.visualizarp = visualizarp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Dar baixa")){
            p = visualizarp.Baixa();
            
            mDao.Insert(p);
            pDao.Delete(p);
            visualizarp.AtualizaTabela();
            
            
            
            
        }
        
    }
    
}
