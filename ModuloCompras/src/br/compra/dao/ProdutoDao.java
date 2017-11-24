package br.compra.dao;

import br.compra.getset.CategoriaGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.getset.ProdutoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDao {

  

    public void Insert(ProdutoGetSet prod) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO produto (idProduto,nome, `data`, estoque_max, estoque_min, saldo, preco_compra, preco_venda, preco_custo, preco_unitario,idCategoria) VALUES (?,?,?,?,?,?,?,?,?,?,?); ";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(prod.getCodigo()));
            ps.setString(2, prod.getNome());
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            try {
                java.sql.Date data = new java.sql.Date(fmt.parse(prod.getData()).getTime());
                ps.setDate(3, data);
            } catch (ParseException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setInt(4, prod.getEst_max());
            ps.setInt(5, prod.getEst_min());
            ps.setInt(6, prod.getSaldo());
            ps.setFloat(7, prod.getPreco_compra());
            ps.setFloat(8, prod.getPreco_venda());
            ps.setFloat(9, prod.getPreco_custo());
            ps.setFloat(10, prod.getPreco_un());
            ps.setInt(11, prod.getCat().getCodigo());
            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Update(ProdutoGetSet prod) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "UPDATE produto SET saldo = saldo + ? where nome = ?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prod.getSaldo());
            ps.setString(2, prod.getNome());
            ps.execute();

//            conn.commit();
        } catch (SQLException e) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean isRegistro(ProdutoGetSet prod) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT nome FROM produto WHERE nome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, prod.getNome());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static int ReadUltimo() throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT idProduto FROM produto ORDER BY idProduto DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("idProduto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<ProdutoGetSet> Read() {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<ProdutoGetSet> produtos = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            String sql = "select prod.idProduto,prod.data,prod.estoque_max,prod.estoque_min,prod.saldo,prod.preco_compra,prod.preco_venda,prod.preco_custo,prod.preco_unitario,prod.idcategoria,prod.nome,cat.nome from produto prod, categoria cat where cat.idcategoria = prod.idcategoria;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {
                ProdutoGetSet prod = new ProdutoGetSet();
                CategoriaGetSet cat = new CategoriaGetSet();

                prod.setCodigo(rs.getInt("prod.idProduto") + "");
                prod.setData(rs.getDate("prod.data") + "");
                prod.setEst_max(rs.getInt("prod.estoque_max"));
                prod.setEst_min(rs.getInt("prod.estoque_min"));
                prod.setSaldo(rs.getInt("prod.saldo"));
                prod.setPreco_compra(rs.getFloat("prod.preco_compra"));
                prod.setPreco_venda(rs.getFloat("prod.preco_venda"));
                prod.setPreco_custo(rs.getFloat("prod.preco_custo"));
                prod.setPreco_un(rs.getFloat("prod.preco_unitario"));
                cat.setCodigo(rs.getInt("prod.idcategoria"));
                prod.setNome(rs.getString("prod.nome"));
                cat.setNome(rs.getString("cat.nome"));

                prod.setCat(cat);
                produtos.add(prod);
            }
            
            sql = "select forn.Nome, forn.email from fornecedor forn where forn.idCategoria = ?;";
            for(int i = 0; i < produtos.size(); i++){
            List<FornecedorGetSet> lisforn = new ArrayList<>();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, produtos.get(i).getCat().getCodigo());
            rs = ps.executeQuery();
            while(rs.next()){
                FornecedorGetSet f = new FornecedorGetSet();
                
                f.setNome(rs.getString("forn.Nome"));
                f.setEmail(rs.getString("forn.email"));
                lisforn.add(f);
                
            }
            produtos.get(i).setF(lisforn);
            }

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;

    }

}
