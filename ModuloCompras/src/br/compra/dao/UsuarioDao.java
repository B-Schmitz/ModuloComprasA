package br.compra.dao;

import br.compra.getset.UsuarioGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao {

    public void Insert(UsuarioGetSet usuario) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO usuarios VALUES (null,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getTipo());
            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Read(UsuarioGetSet usuario) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "SELECT nome, senha, email, tipo FROM usuarios where nome = ? or email = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getEmail());
            rs = ps.executeQuery();

            while (rs.next()) {
                
                String u = rs.getString("nome");
                
                if(u.equals(usuario.getUsuario())){
                usuario.setUsuario(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTipo(rs.getString("tipo"));
                }
            }

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean isRegistro(UsuarioGetSet usuario) throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT nome FROM usuarios WHERE nome = ? or email = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getEmail());
            rs = ps.executeQuery();
           while(rs.next()){
               
               String usuari = rs.getString("nome");
               if(usuario.getUsuario().equals(usuari)){
                   
                   
                  return true;
                   
               }
               
           }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
