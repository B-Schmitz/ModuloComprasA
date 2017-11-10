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
    private final DefaultTableModel model_endereco;
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
        model_endereco = (DefaultTableModel) tabela_endereco.getModel();
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

    private void Limpar() {
        model_imposto.setNumRows(0);
        model_transportador.setNumRows(0);
        model_itens.setNumRows(0);
        model_endereco.setNumRows(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        tabela_transportador = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabela_endereco = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_impostos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_notasfiscais = new javax.swing.JTable();
        label_nota = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_itens = new javax.swing.JTable();
        label_itens = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Nota Fiscal");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

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
        tabela_transportador.setRowHeight(19);
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

        jLabel1.setText("Transportador");

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
        tabela_endereco.setRowHeight(19);
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

        jLabel2.setText("Endereço");

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
        tabela_impostos.setRowHeight(19);
        tabela_impostos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabela_impostos);
        if (tabela_impostos.getColumnModel().getColumnCount() > 0) {
            tabela_impostos.getColumnModel().getColumn(0).setResizable(false);
            tabela_impostos.getColumnModel().getColumn(1).setResizable(false);
            tabela_impostos.getColumnModel().getColumn(2).setResizable(false);
            tabela_impostos.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel3.setText("Impostos");

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

        label_nota.setText("Notas Fiscais");

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

        label_itens.setText("Itens");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nota)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(label_itens))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_nota)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_itens)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_notasfiscaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_notasfiscaisMouseClicked
        if (evt.getClickCount() == 2) {

         Limpar();

            if (tabela_notasfiscais.getSelectedRow() != -1) {
                Integer codNota = (Integer) model_nota.getValueAt(tabela_notasfiscais.getSelectedRow(), 0);
                nota = new NotaGetSet();

                for (int j = 0; j < notas.size(); j++) {
                    if (codNota.equals(notas.get(j).getIdNotaFiscal())) {

                        nota = notas.get(j);
                        break;

                    }
                }

                model_endereco.addRow(new Object[]{nota.getE().getPais(), nota.getE().getEstado(), nota.getE().getCidade(), nota.getE().getBairro(), nota.getE().getRua(), nota.getE().getCEP()});
                model_imposto.addRow(new Object[]{nota.getBaseDeCalculoDo_ICMS(), nota.getBaseDeCalculoDo_ICMS_ST(), nota.getValorDo_ICMS(), nota.getValorDo_ICMS_substituicao()});
                model_transportador.addRow(new Object[]{nota.getNome(), nota.getFrete(), nota.getEspecie(), nota.getNumeracao(), nota.getPeso_bruto(), nota.getPeso_liquido(), nota.getCodigo_antt(), nota.getValorSeguro()});

                for (int j = 0; j < nota.getLisNotaItem().size(); j++) {
                    model_itens.addRow(new Object[]{nota.getLisNotaItem().get(j).getIdProduto(), nota.getLisNotaItem().get(j).getP().getNome(), nota.getLisNotaItem().get(j).getQuantidade(), nota.getLisNotaItem().get(j).getPreco()});

                }
            }
        }
    }//GEN-LAST:event_tabela_notasfiscaisMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Limpar();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel label_itens;
    private javax.swing.JLabel label_nota;
    private javax.swing.JTable tabela_endereco;
    private javax.swing.JTable tabela_impostos;
    private javax.swing.JTable tabela_itens;
    private javax.swing.JTable tabela_notasfiscais;
    private javax.swing.JTable tabela_transportador;
    // End of variables declaration//GEN-END:variables
}
