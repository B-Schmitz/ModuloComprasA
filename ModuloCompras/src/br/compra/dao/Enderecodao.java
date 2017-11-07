package br.compra.dao;

import br.compra.getset.EnderecoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enderecodao {

    public EnderecoGetSet Insert(EnderecoGetSet e) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO bairro (nome) VALUES (?); ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getBairro());
            ps.execute();

            sql = "INSERT INTO rua (nome) VALUES (?); ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getRua());
            ps.execute();

            sql = "INSERT INTO cidade (nome) VALUES (?); ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getCidade());
            ps.execute();

            sql = "INSERT INTO estado (nome) VALUES (?); ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getEstado());
            ps.execute();

            sql = "INSERT INTO pais (nome) VALUES (?); ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getPais());
            ps.execute();

            sql = "select max(idPais) from pais; ";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdPais(rs.getInt("max(idPais)"));
            }

            sql = "select max(idBairro) from bairro; ";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdBairro(rs.getInt("max(idBairro)"));
            }

            sql = "select max(idRua) from rua; ";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdRua(rs.getInt("max(idRua)"));
            }

            sql = "select max(idCidade) from cidade; ";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdCidade(rs.getInt("max(idCidade)"));
            }

            sql = "select max(idEstado) from estado; ";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdEstado(rs.getInt("max(idEstado)"));
            }

            sql = "INSERT INTO endereco (idRua,idPais,idEstado,idBairro,idCidade,CEP) VALUES (?,?,?,?,?,?); ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, e.getIdRua());
            ps.setInt(2, e.getIdPais());
            ps.setInt(3, e.getIdEstado());
            ps.setInt(4, e.getIdBairro());
            ps.setInt(5, e.getIdCidade());
            ps.setInt(6, e.getCEP());
            ps.execute();

            sql = "select max(idEndereco) from endereco; ";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdEndereco(rs.getInt("max(idEndereco)"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;

    }

}
