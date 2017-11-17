
package br.compra.dao;

import br.compra.getset.FornecedorGetSet;
import br.compra.getset.MovimentoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MovimentoDao {
   

    private FornecedorGetSet forn;
    int id;

    public void Insert(MovimentoGetSet m)  throws SQLException{

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO movimentacao_compra (data) VALUES (current_date()); ";
            ps = conn.prepareStatement(sql);

            ps.execute();
            sql = "SELECT MAX(idMovimentacao_compra) FROM movimentacao_compra ;";
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                id = rs.getInt("MAX(idMovimentacao_compra)");
                
            }

            // conn.commit();
            
            sql = "INSERT INTO movimentacao_compra_item (Quantidade,preco,idMovimentacao_compra,idProduto,idFornecedor) VALUES (?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            
            for(int i = 0; i < m.getLisMovimento().size(); i++){
                
           ps.setInt(1, m.getLisMovimento().get(i).getQuantidade());
           ps.setDouble(2, m.getLisMovimento().get(i).getPreco());
           ps.setInt(3, id);
           ps.setInt(4, Integer.valueOf(m.getLisMovimento().get(i).getP().getCodigo()));
           ps.setInt(5, Integer.valueOf(m.getLisMovimento().get(i).getF().getCodigo()));
           ps.execute();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
