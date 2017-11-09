package br.compra.dao;

import br.compra.getset.CategoriaGetSet;
import br.compra.getset.EnderecoGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.getset.ProdutoGetSet;
import br.compra.getset.RequisicaoGetSet;
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

public class RequisicaoDao {

    public void Insert(RequisicaoGetSet req) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO reqcompras (idreqcompras,data,solicitante,chefe,setor,observacoes) VALUES (?,?,?,?,?,?); ";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, req.getNumRequisicao());
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data;
            try {
                data = new java.sql.Date(fmt.parse(req.getData()).getTime());
                ps.setDate(2, data);
            } catch (ParseException ex) {
                Logger.getLogger(RequisicaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setString(3, req.getSolicitante());
            ps.setString(4, req.getChefe());
            ps.setString(5, req.getSetor());
            ps.setString(6, req.getObservacoes());

            ps.execute();

            int id = 0;
            sql = "SELECT MAX(idreqcompras) FROM reqcompras; ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("MAX(idreqcompras)");

            }

            System.out.println(id);

            //
            sql = "INSERT INTO reqcompras_item (idProduto,idreqcompras,quantidade,Prioridade) VALUES (?,?,?,?); ";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < req.getLisproduto().size(); i++) {

                ps.setInt(1, Integer.parseInt(req.getLisproduto().get(i).getCodigo()));
                ps.setInt(2, id);
                ps.setInt(3, Integer.parseInt(req.getQuantidade().get(i)));
                ps.setString(4, req.getPrioridade());
                ps.execute();
            }
            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(RequisicaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int ReadUltimo() throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "SELECT idreqcompras FROM reqcompras ORDER BY idreqcompras DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("idreqcompras");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequisicaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<RequisicaoGetSet> read() {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<ProdutoGetSet> Codigo_produto = new ArrayList<>();
        List<String> Quantidade = new ArrayList<>();
        List<RequisicaoGetSet> lisReq = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            String sql = "select idReqcompras, data, solicitante, chefe, setor, observacoes from Reqcompras";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                RequisicaoGetSet req = new RequisicaoGetSet();

                req.setNumRequisicao(rs.getInt("idReqcompras"));
                req.setData(rs.getString("data"));
                req.setSolicitante(rs.getString("solicitante"));
                req.setChefe(rs.getString("chefe"));
                req.setSetor(rs.getString("setor"));
                req.setObservacoes(rs.getString("observacoes"));

                lisReq.add(req);

            }

            sql = "select pro.idProduto,pro.nome,pro.data,pro.estoque_max,pro.estoque_min, pro.saldo,"
                    + "pro.preco_compra,pro.preco_venda,pro.preco_unitario,ca.Nome,ca.idcategoria,"
                    + "ri.quantidade,ri.Prioridade from reqcompras_item ri,produto  pro, categoria ca "
                    + "where ri.idreqcompras =  ? and ri.idProduto = pro.idProduto and ca.idcategoria = pro.idcategoria;";
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < lisReq.size(); i++) {
                ps.setInt(1, lisReq.get(i).getNumRequisicao());
                rs = ps.executeQuery();
                while (rs.next()) {
                    ProdutoGetSet p = new ProdutoGetSet();
                    CategoriaGetSet cat = new CategoriaGetSet();

                    p.setCodigo(rs.getInt("pro.idProduto") + "");
                    p.setNome(rs.getString("pro.nome"));
                    p.setData(rs.getString("pro.data"));
                    p.setEst_max(rs.getInt("pro.estoque_max"));
                    p.setEst_min(rs.getInt("pro.estoque_min"));
                    p.setSaldo(rs.getInt("pro.saldo"));
                    p.setPreco_compra(rs.getFloat("pro.preco_compra"));
                    p.setPreco_venda(rs.getFloat("pro.preco_venda"));
                    p.setPreco_un(rs.getFloat("pro.preco_unitario"));
                    cat.setNome(rs.getString("ca.Nome"));
                    cat.setCodigo(rs.getInt("ca.idcategoria"));
                    p.setCat(cat);
                    Quantidade.add(rs.getInt("ri.quantidade") + "");
                    lisReq.get(i).setPrioridade(rs.getString("ri.Prioridade"));;

                    Codigo_produto.add(p);
                }
                lisReq.get(i).setQuantidade(Quantidade);
                lisReq.get(i).setLisproduto(Codigo_produto);
                Codigo_produto = new ArrayList<>();
                Quantidade = new ArrayList<>();

            }
            List<FornecedorGetSet> lisforn = null;
            sql = "select forn.Nome, forn.email,forn.idfornecedor,forn.cnpj,forn.telefone,forn.idEndereco from fornecedor forn, produto pro, categoria ca "
                    + "where pro.idcategoria = ca.idcategoria and ca.idCategoria = forn.idCategoria and pro.idProduto = ?;";
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < lisReq.size(); i++) {

                for (int j = 0; j < lisReq.get(i).getLisproduto().size(); j++) {

                    ps.setInt(1, Integer.parseInt(lisReq.get(i).getLisproduto().get(j).getCodigo()));
                    rs = ps.executeQuery();

                    lisforn = new ArrayList<>();
                    while (rs.next()) {
                        FornecedorGetSet forn = new FornecedorGetSet();

                        forn.setNome(rs.getString("forn.Nome"));
                        forn.setEmail(rs.getString("forn.email"));
                        forn.setCNPJ(rs.getString("forn.cnpj"));
                        forn.setCodigo(rs.getInt("idfornecedor") + "");
                        forn.setTelefone(rs.getLong("forn.telefone") + "");
                        EnderecoGetSet end = new EnderecoGetSet();
                        end.setIdEndereco(rs.getInt("forn.idEndereco"));
                        forn.setE(end);

                        lisforn.add(forn);
                    }
                    lisReq.get(i).getLisproduto().get(j).setF(lisforn);

                }

            }

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(RequisicaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lisReq;

    }

    public void Delete(RequisicaoGetSet req) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from reqcompras_item where idreqcompras = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, req.getNumRequisicao());
            ps.execute();

            conn = Conexao.getConnection();
            sql = "delete from reqcompras where idreqcompras= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, req.getNumRequisicao());
            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            //  System.out.println("ERRO: " + e.getMessage());

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
