package br.compra.dao;

import br.compra.getset.NotaGetSet;
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
                
                nota.setIdTransportador(rs.getInt("n.idTransportador"));
                nota.setIdVeiculo(rs.getInt("tra.idVeiculo"));
                
                

                notas.add(nota);
            }

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return notas;

    }

}

/*SELECT n.idNotaFiscal, n.baseDeCalculoDo_ICMS, n.baseDeCalculoDo_ICMS_ST, n.data_emissao,n.numero, n.valorDo_ICMS, n.valorDo_ICMS_substituicao,
p.nome, es.nome, ci.nome, ba.nome, ru.Nome, e.CEP, tra.codigo_antt, tra.especie, tra.frete, tra.nome, tra.numeracao, tra.peso_bruto, tra.peso_liquido,
tra.valorSeguro, ve.marca, ve.modelo, ve.placa FROM notafiscal n, endereco e, transportador tra, pais p, estado es, cidade ci, bairro ba, rua ru,
veiculo ve WHERE n.idEndereco  = e.idEndereco and e.idPais = p.idPais and e.idEstado = es.idEstado and e.idCidade = ci.idCidade
 and e.idBairro = ba.idBairro and e.idRua = ru.idRua and n.idTransportador = tra.idTransportador and ve.idVeiculo = tra.idVeiculo;
 */
