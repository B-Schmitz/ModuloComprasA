
package br.compra.dao;

import br.compra.getset.CategoriaGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.getset.MovimentoItem;
import br.compra.getset.MovimetoGetSet;
import br.compra.getset.PedidoGetSet;
import br.compra.getset.ProdutoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
      
      public List<MovimentoItem> Read() {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<MovimentoItem> itens = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT ci.Quantidade, ci.preco,mc.data, p.nome, f.Nome FROM movimentacao_compra_item ci , produto p, fornecedor f,movimentacao_compra mc\n" +
"                    WHERE ci.idMovimentacao_compra = mc.idMovimentacao_compra and ci.idProduto = p.idProduto and ci.idFornecedor = f.idFornecedor;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {
               MovimentoItem m = new MovimentoItem();
               ProdutoGetSet p = new ProdutoGetSet();
               FornecedorGetSet f = new FornecedorGetSet();

               List<FornecedorGetSet> lisf = new ArrayList<>();
               
               m.setQuant(rs.getInt("ci.Quantidade"));
               m.setPreco(rs.getDouble("ci.preco"));
               m.setData(rs.getDate("mc.data") + "");
               p.setNome(rs.getString("p.nome"));
               f.setNome(rs.getString("f.Nome"));
               lisf.add(f);
               p.setF(lisf);
               m.setP(p);
               
               itens.add(m);
                        
            }
            
        
        

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return itens;

    }
    
}
