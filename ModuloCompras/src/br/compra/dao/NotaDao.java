package br.compra.dao;

import br.compra.getset.EnderecoGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.getset.NotaGetSet;
import br.compra.getset.NotaItemGetSet;
import br.compra.getset.ProdutoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaDao {
    
    public List<NotaGetSet> Read() {
        
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        
        List<NotaGetSet> notas = new ArrayList<>();
        List<NotaItemGetSet> notasItem = new ArrayList<>();
        
        try {
            conn = Conexao.getConnection();
            String sql = "SELECT n.idNotaFiscal, n.baseDeCalculoDo_ICMS, n.baseDeCalculoDo_ICMS_ST, n.data_emissao,n.numero, n.valorDo_ICMS, n.valorDo_ICMS_substituicao,\n"
                    + "p.nome, es.nome, ci.nome, ba.nome, ru.Nome, e.CEP, tra.codigo_antt, tra.especie, tra.frete, tra.nome, tra.numeracao, tra.peso_bruto, tra.peso_liquido,\n"
                    + "tra.valorSeguro, ve.marca, ve.modelo, ve.placa FROM notafiscal n, endereco e, transportador tra, pais p, estado es, cidade ci, bairro ba, rua ru,\n"
                    + "veiculo ve WHERE n.idEndereco = e.idEndereco and e.idPais = p.idPais and e.idEstado = es.idEstado and e.idCidade = ci.idCidade\n"
                    + "and e.idBairro = ba.idBairro and e.idRua = ru.idRua and n.idTransportador = tra.idTransportador and ve.idVeiculo = tra.idVeiculo;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                NotaGetSet nota = new NotaGetSet();
                
                nota.setIdNotaFiscal(rs.getInt("n.idNotaFiscal"));
                nota.setNumeracao(rs.getInt("n.numero"));
                nota.setData_emissao(rs.getDate("n.data_emissao") + "");
                
                nota.setBaseDeCalculoDo_ICMS(rs.getInt("n.baseDeCalculoDo_ICMS"));
                nota.setBaseDeCalculoDo_ICMS_ST(rs.getInt("n.baseDeCalculoDo_ICMS_ST"));
                nota.setValorDo_ICMS(rs.getDouble("n.valorDo_ICMS"));
                nota.setValorDo_ICMS_substituicao(rs.getDouble("n.valorDo_ICMS_substituicao"));
                
                nota.setModelo(rs.getString("ve.modelo"));
                nota.setMarca(rs.getString("ve.marca"));
                nota.setPlaca(rs.getString("ve.placa"));
                
                nota.setEspecie(rs.getString("tra.especie"));
                nota.setFrete(rs.getDouble("tra.frete"));
                nota.setNome(rs.getString("tra.nome"));
                nota.setNumeracao(rs.getInt("tra.numeracao"));
                nota.setPeso_bruto(rs.getFloat("tra.peso_bruto"));
                nota.setPeso_liquido(rs.getFloat("tra.peso_liquido"));
                nota.setCodigo_antt(rs.getInt("tra.codigo_antt"));
                nota.setValorSeguro(rs.getDouble("tra.valorSeguro"));
                
                EnderecoGetSet e = new EnderecoGetSet();
                e.setPais(rs.getString("p.nome"));
                e.setEstado(rs.getString("es.nome"));
                e.setCidade(rs.getString("ci.nome"));
                e.setBairro(rs.getString("ba.nome"));
                e.setRua(rs.getString("ru.nome"));
                e.setCEP(rs.getInt("e.CEP"));
                
                nota.setE(e);
                
                notas.add(nota);
            }
            
            sql = "SELECT ni.idNotaFiscal_Item, ni.idProduto, ni.quantidade, ni.preco, p.nome , f.Nome FROM notafiscal_item ni,produto p ,fornecedor f  WHERE p.idProduto = ni.idProduto AND f.idFornecedor = ni.idFornecedor AND ni.idNotaFiscal = ?;";
            ps = conn.prepareStatement(sql);
            
            for (int i = 0; i < notas.size(); i++) {
                
                ps.setInt(1, notas.get(i).getIdNotaFiscal());
                rs = ps.executeQuery();
                
                    notasItem = new ArrayList<>();
                while (rs.next()) {
                    NotaItemGetSet notaItem = new NotaItemGetSet();
                    
                    notaItem.setPreco(rs.getDouble("ni.preco"));
                    notaItem.setQuantidade(rs.getInt("ni.quantidade"));
                    notaItem.setIdNotaFiscal_Item(rs.getInt("ni.idNotaFiscal_Item"));
                    notaItem.setIdProduto(rs.getInt("ni.idProduto"));
                    ProdutoGetSet p = new ProdutoGetSet();
                    p.setNome(rs.getString("p.nome"));
                    FornecedorGetSet f = new FornecedorGetSet();
                    f.setNome("f.Nome");
                    notaItem.setF(f);
                    notaItem.setP(p);
                    
                    notasItem.add(notaItem);
                    notas.get(i).setLisNotaItem(notasItem);
                }
                
            }
            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return notas;
        
    }
    
}
