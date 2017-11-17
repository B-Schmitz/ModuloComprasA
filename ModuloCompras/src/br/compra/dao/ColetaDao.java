package br.compra.dao;

import br.compra.getset.ColetaGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColetaDao {

    public void Insert(List<ColetaGetSet> lis) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        for (int i = 0; i < lis.size(); i++) {
            try {

                conn = Conexao.getConnection();
                String sql = "insert into coleta_preco (data,valor_estimado) values(current_date(),?); ";
                ps = conn.prepareStatement(sql);

                ps.setDouble(1, lis.get(i).getValorEstimado());

                ps.execute();
                sql = "SELECT max(idColeta_preco) FROM coleta_preco;";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                if (rs.next()) {
                    lis.get(i).setCodigoColeta(rs.getInt("max(idColeta_preco)"));
                }

                sql = "insert into coleta_preco_item (data_prevista,quantidade,idColeta_preco,idProduto,idfornecedor,preco) values(?,?,?,?,?,?); ";
                ps = conn.prepareStatement(sql);

                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data;
                try {
                    data = new java.sql.Date(fmt.parse(lis.get(i).getDataPrevista()).getTime());
                    ps.setDate(1, data);
                } catch (ParseException ex) {
                    Logger.getLogger(ColetaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ps.setInt(2, lis.get(i).getQuantidade());
                ps.setInt(3, lis.get(i).getCodigoColeta());
                ps.setInt(4, Integer.valueOf(lis.get(i).getP().getCodigo()));
                ps.setInt(5, Integer.valueOf(lis.get(i).getF().getCodigo()));
                ps.setDouble(6, lis.get(i).getPreco_unitario());

                ps.execute();
                // conn.commit();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
