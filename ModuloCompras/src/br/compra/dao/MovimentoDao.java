
package br.compra.dao;

import br.compra.getset.MovimetoGetSet;
import br.compra.getset.PedidoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MovimentoDao {
    
    
      public void Insert(PedidoGetSet p) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MovimetoGetSet m = new MovimetoGetSet();
        int id = -1;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO movimentacao_compra (data) VALUES (current_date()); ";
            ps = conn.prepareStatement(sql);


            ps.execute();
            
            sql = "SELECT max(idMovimentacao_compra) FROM movimentacao_compra";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("max(idMovimentacao_compra)");
            }
            
            sql = "INSERT INTO movimentacao_compra_item (Quantidade,preco,idMovimentacao_compra,idProduto,idFornecedor) VALUES (?,?,?,?,?); ";
            ps = conn.prepareStatement(sql);
            
            for(int i = 0; i < p.getpItem().size(); i++){
                
                
                
            ps.setInt(1, p.getpItem().get(i).getQuantidade());
            ps.setDouble(2, p.getpItem().get(i).getPreco());
            ps.setInt(3, id);
            ps.setInt(4, Integer.valueOf(p.getpItem().get(i).getP().getCodigo()));
            ps.setInt(5,Integer.valueOf(p.getpItem().get(i).getP().getF().get(0).getCodigo()));
            ps.execute();
            
        }
            
            //conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
