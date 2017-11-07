package br.compra.dao;

import br.compra.getset.FornecedorGetSet;
import br.compra.getset.PedidoGetSet;
import br.compra.getset.PedidoItemGetSet;
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

public class PedidoDao {

    public void Insert(PedidoGetSet pedido) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "INSERT INTO pedido_compra (idPedido_compra, data,  valor_estimado) VALUES (?, ?, ?);";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedidoCompra());
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            try {
                java.sql.Date data = new java.sql.Date(fmt.parse(pedido.getData()).getTime());
                ps.setDate(2, data);
            } catch (ParseException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setDouble(3, pedido.getValor_estimado());

            ps.execute();

            sql = "INSERT INTO pedido_compra_item (data_prevista, quantidade, preco, idPedido_compra, idProduto, idFornecedor) VALUES (?, ?, ?, ?, ?, ?);";

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < pedido.getpItem().size(); i++) {

                fmt = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    java.sql.Date data = new java.sql.Date(fmt.parse(pedido.getpItem().get(i).getDataPrevista()).getTime());
                    ps.setDate(1, data);
                } catch (ParseException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }

                ps.setInt(2, pedido.getpItem().get(i).getQuantidade());
                ps.setDouble(3, pedido.getpItem().get(i).getPreco());
                ps.setInt(4, pedido.getIdPedidoCompra());
                ps.setInt(5, Integer.valueOf(pedido.getpItem().get(i).getP().getCodigo()));
                ps.setInt(6, Integer.valueOf(pedido.getpItem().get(i).getP().getF().get(0).getCodigo()));
                ps.execute();

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

    }
    
    public static int ReadUltimo() throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT idPedido_compra FROM pedido_compra ORDER BY idPedido_compra DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("idPedido_compra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    

    public List<PedidoGetSet> read(List<PedidoGetSet> lisP) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            System.out.println("yyyyy");
            conn = Conexao.getConnection();
            String sql = "SELECT idPedido_compra, data, valor_estimado from pedido_compra";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                PedidoGetSet p = new PedidoGetSet();

                p.setIdPedidoCompra(rs.getInt("idPedido_compra"));
                p.setData(rs.getString("data"));
                p.setValor_estimado(rs.getDouble("valor_estimado"));

                lisP.add(p);
            }

            sql = "SELECT pci.idPedido_compra_item,pci.data_prevista,pci.quantidade,pci.preco,p.nome,p.idProduto,f.Nome,f.idFornecedor\n"
                    + " from pedido_compra_item pci,produto p ,fornecedor f \n"
                    + "WHERE pci.idProduto = p.idProduto AND pci.idFornecedor = f.idFornecedor AND pci.idPedido_compra = ?;";

            ps = conn.prepareStatement(sql);

            List<PedidoItemGetSet> lispItem = new ArrayList<>();
            List<FornecedorGetSet> lisForn = new ArrayList<>();

            for (int i = 0; i < lisP.size(); i++) {
                ps.setInt(1, lisP.get(i).getIdPedidoCompra());
                rs = ps.executeQuery();
                while (rs.next()) {

                    PedidoItemGetSet pItem = new PedidoItemGetSet();

                    pItem.setIdPedidoCompra(lisP.get(i).getIdPedidoCompra());
                    pItem.setIdPedidoCompraItem(rs.getInt("pci.idPedido_compra_item"));
                    pItem.setDataPrevista(String.valueOf(rs.getDate("pci.data_prevista")));
                    pItem.setQuantidade(rs.getInt("pci.quantidade"));
                    pItem.setPreco(rs.getDouble("pci.preco"));
                    ProdutoGetSet prod = new ProdutoGetSet();
                    prod.setNome(rs.getString("p.nome"));
                    prod.setCodigo(String.valueOf(rs.getInt("p.idProduto")));
                    pItem.setP(prod);
                    FornecedorGetSet forn = new FornecedorGetSet();
                    forn.setNome(rs.getString("f.Nome"));
                    forn.setCodigo(String.valueOf(rs.getInt("f.idFornecedor")));
                    lisForn.add(forn);
                    pItem.getP().setF(lisForn);

                    lispItem.add(pItem);

                }
                lisP.get(i).setpItem(lispItem);

            }
            conn.commit();
        } catch (SQLException e) {
            // System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                  //   System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                //    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                  //   System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return lisP;
    }
    
    public void Delete(PedidoGetSet p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from pedido_compra_item where idPedido_compra = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getIdPedidoCompra());
            ps.execute();
            
            conn = Conexao.getConnection();
            sql = "delete from pedido_compra where idPedido_compra = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getIdPedidoCompra());
            ps.execute();

           

            conn.commit();
        } catch (SQLException e) {
             System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                       System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }
}
