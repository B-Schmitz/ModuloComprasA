package br.compra.telas;

import br.compra.dao.NotaDao;
import br.compra.getset.NotaGetSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class NotaFiscal extends javax.swing.JInternalFrame {

    private NotaGetSet nota;
    private final NotaDao notaDao = new NotaDao();
    private final DefaultTableModel model_nota;
    private final DefaultTableModel model_imposto;
    private final DefaultTableModel model_transportador;
    private final DefaultTableModel model_itens;
    private List<NotaGetSet> notas;

    public NotaFiscal() {
        initComponents();
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/receipt_invoice.png"));
        model_nota = (DefaultTableModel) tabela_notasfiscais.getModel();
        model_imposto = (DefaultTableModel) tabela_impostos.getModel();
        model_transportador = (DefaultTableModel) tabela_transportador.getModel();
        model_itens = (DefaultTableModel) tabela_itens.getModel();
        AtualizaLista();

    }

    public final void AtualizaLista() {

        notas = notaDao.Read();

        DefaultTableModel model_nota = (DefaultTableModel) tabela_notasfiscais.getModel();
        model_nota.setNumRows(0);

        for (int i = 0; i < notas.size(); i++) {

            model_nota.addRow(new Object[]{notas.get(i).getIdNotaFiscal(), notas.get(i).getNumeracao(), notas.get(i).getData_emissao(), 3});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_notasfiscais = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_itens = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_impostos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabela_transportador = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabela_endereco = new javax.swing.JTable();

        setClosable(true);
        setTitle("Nota Fiscal");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota Fiscal"));
        jPanel2.setToolTipText("");

        tabela_notasfiscais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Número", "Data Emissão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_notasfiscais.getTableHeader().setReorderingAllowed(false);
        tabela_notasfiscais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_notasfiscaisMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela_notasfiscais);
        if (tabela_notasfiscais.getColumnModel().getColumnCount() > 0) {
            tabela_notasfiscais.getColumnModel().getColumn(0).setResizable(false);
            tabela_notasfiscais.getColumnModel().getColumn(1).setResizable(false);
            tabela_notasfiscais.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));

        tabela_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Prod", "Produto", "Quantidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_itens.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela_itens);
        if (tabela_itens.getColumnModel().getColumnCount() > 0) {
            tabela_itens.getColumnModel().getColumn(0).setResizable(false);
            tabela_itens.getColumnModel().getColumn(1).setResizable(false);
            tabela_itens.getColumnModel().getColumn(2).setResizable(false);
            tabela_itens.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Impostos"));

        tabela_impostos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Base de cálculo do ICMS", "Base de cálculo do ICMS-ST", "Valor ICMS", "Valor ICMS Substituição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_impostos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabela_impostos);
        if (tabela_impostos.getColumnModel().getColumnCount() > 0) {
            tabela_impostos.getColumnModel().getColumn(0).setResizable(false);
            tabela_impostos.getColumnModel().getColumn(1).setResizable(false);
            tabela_impostos.getColumnModel().getColumn(2).setResizable(false);
            tabela_impostos.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Transportador"));

        tabela_transportador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Frete", "Espécie", "Numeração", "Peso Bruto", "Peso Líquido", "Código Antt", "Valor Seguro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_transportador.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabela_transportador);
        if (tabela_transportador.getColumnModel().getColumnCount() > 0) {
            tabela_transportador.getColumnModel().getColumn(0).setResizable(false);
            tabela_transportador.getColumnModel().getColumn(1).setResizable(false);
            tabela_transportador.getColumnModel().getColumn(2).setResizable(false);
            tabela_transportador.getColumnModel().getColumn(3).setResizable(false);
            tabela_transportador.getColumnModel().getColumn(4).setResizable(false);
            tabela_transportador.getColumnModel().getColumn(5).setResizable(false);
            tabela_transportador.getColumnModel().getColumn(6).setResizable(false);
            tabela_transportador.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        tabela_endereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "País", "Estado", "Cidade", "Bairro", "Rua", "CEP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_endereco.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabela_endereco);
        if (tabela_endereco.getColumnModel().getColumnCount() > 0) {
            tabela_endereco.getColumnModel().getColumn(0).setResizable(false);
            tabela_endereco.getColumnModel().getColumn(1).setResizable(false);
            tabela_endereco.getColumnModel().getColumn(2).setResizable(false);
            tabela_endereco.getColumnModel().getColumn(3).setResizable(false);
            tabela_endereco.getColumnModel().getColumn(4).setResizable(false);
            tabela_endereco.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_notasfiscaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_notasfiscaisMouseClicked
        if (evt.getClickCount() == 2) {

            model_imposto.setNumRows(0);
            model_transportador.setNumRows(0);
            model_itens.setNumRows(0);
            if(tabela_notasfiscais.getSelectedRow() != -1){
            for (int i = 0; i < notas.size(); i++) {
                model_imposto.addRow(new Object[]{notas.get(i).getBaseDeCalculoDo_ICMS(), notas.get(i).getBaseDeCalculoDo_ICMS_ST(), notas.get(i).getValorDo_ICMS(), notas.get(i).getValorDo_ICMS_substituicao(), 4});
                model_transportador.addRow(new Object[]{notas.get(i).getNome(), notas.get(i).getFrete(), notas.get(i).getEspecie(), notas.get(i).getNumeracao(), notas.get(i).getPeso_bruto(), notas.get(i).getPeso_liquido(), notas.get(i).getCodigo_antt(), notas.get(i).getValorSeguro(), 8});
            }

            Integer codNota = (Integer) model_nota.getValueAt(tabela_notasfiscais.getSelectedRow(), 0);
            nota = new NotaGetSet();

            for (int j = 0; j < notas.size(); j++) {

                if (codNota.equals(notas.get(j).getIdNotaFiscal())) {

                    nota = notas.get(j);
                    break;

                }
            }

            for (int j = 0; j < nota.getLisNotaItem().size(); j++) {
                model_itens.addRow(new Object[]{nota.getLisNotaItem().get(j).getIdProduto(), nota.getLisNotaItem().get(j).getP().getNome(), nota.getLisNotaItem().get(j).getQuantidade(), nota.getLisNotaItem().get(j).getPreco(), 4});

            }
        }
        }

    }//GEN-LAST:event_tabela_notasfiscaisMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tabela_endereco;
    private javax.swing.JTable tabela_impostos;
    private javax.swing.JTable tabela_itens;
    private javax.swing.JTable tabela_notasfiscais;
    private javax.swing.JTable tabela_transportador;
    // End of variables declaration//GEN-END:variables
}
