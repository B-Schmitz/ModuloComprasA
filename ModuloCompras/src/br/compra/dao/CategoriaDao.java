package br.compra.dao;

import br.compra.getset.CategoriaGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDao {

    public int buscaCat(String nome) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        int id = -1;
        try {
            conn = Conexao.getConnection();
            String sql = "SELECT idcategoria from categoria where nome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();

            if (rs.next()) {


                id = rs.getInt("idcategoria");
                
            }

            conn.commit();
        } catch (SQLException e) {
            // System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        

        return id;
    }

    public List<CategoriaGetSet> read(List<CategoriaGetSet> cat) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT idcategoria, nome from categoria";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                CategoriaGetSet c = new CategoriaGetSet();

                c.setCodigo(rs.getInt("idcategoria"));
                c.setNome(rs.getString("Nome"));
                cat.add(c);

            }

            conn.commit();
        } catch (SQLException e) {
            // System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return cat;
    }

    public void Insert(String cat) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO categoria (Nome) VALUES (?); ";
            ps = conn.prepareStatement(sql);

            ps.setString(1, cat);

            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
