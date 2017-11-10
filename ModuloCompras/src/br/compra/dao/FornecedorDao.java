package br.compra.dao;

import br.compra.getset.CategoriaGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.getset.ProdutoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDao {

    FornecedorGetSet forn;

    public void Insert(FornecedorGetSet f) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO fornecedor (idfornecedor,Nome,cnpj,telefone,email,idEndereco,idCategoria) VALUES (?,?,?,?,?,?,?); ";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(f.getCodigo()));
            ps.setString(2, f.getNome());
            ps.setLong(3, Long.parseLong(f.getCNPJ()));
            ps.setLong(4, Long.parseLong(f.getTelefone()));
            ps.setString(5, f.getEmail());
            ps.setInt(6, f.getE().getIdEndereco());
            ps.setInt(7, f.getCat().getCodigo());

            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public boolean isRegistro(FornecedorGetSet forn) throws SQLException {
        
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
       
        try {
            conn = Conexao.getConnection();
            String sql = "SELECT nome FROM fornecedor WHERE nome = ? or lpad(cnpj,14,0) = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, forn.getNome());
            ps.setString(2, forn.getCNPJ());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public FornecedorGetSet BuscaNome(FornecedorGetSet forn) throws SQLException {
        
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
       
        try {
            conn = Conexao.getConnection();
            String sql = "SELECT idfornecedor FROM fornecedor WHERE nome = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, forn.getNome());
            rs = ps.executeQuery();
            if(rs.next()){
                
                forn.setCodigo(rs.getInt("idfornecedor") +"");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return forn;
    }

    public int ReadUltimo() throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT idFornecedor FROM fornecedor ORDER BY idFornecedor DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("idFornecedor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<FornecedorGetSet> read(String ramo) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;


        try {
            conn = Conexao.getConnection();
            String sql = "select idfornecedor,Nome,cnpj,telefone,email,idEndereco from fornecedor where idCategoria = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ramo);
            rs = ps.executeQuery();

            CategoriaGetSet cat = new CategoriaGetSet();

            while (rs.next()) {
                ProdutoGetSet prod = new ProdutoGetSet();

                prod.setCodigo(rs.getInt("idProduto") + "");
                prod.setData(rs.getDate("data") + "");
                prod.setEst_max(rs.getInt("estoque_max"));
                prod.setEst_min(rs.getInt("estoque_min"));
                prod.setSaldo(rs.getInt("saldo"));
                prod.setPreco_compra(rs.getFloat("preco_compra"));
                prod.setPreco_venda(rs.getFloat("preco_venda"));
                prod.setPreco_un(rs.getFloat("preco_unitario"));
                cat.setCodigo(rs.getInt("idcategoria"));
                prod.setCat(cat);
                prod.setNome(rs.getString("nome"));

                //   produtos.add(prod);
            }

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}
