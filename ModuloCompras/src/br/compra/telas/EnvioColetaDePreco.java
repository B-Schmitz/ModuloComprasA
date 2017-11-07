package br.compra.telas;

import br.compra.getset.ProdutoGetSet;
import br.compra.getset.RequisicaoGetSet;
import br.compra.listeners.EnvioColetaListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class EnvioColetaDePreco extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
    private DefaultTableModel model2;
    private RequisicaoGetSet req;

    public EnvioColetaDePreco() {
        initComponents();
        bnt_Cancelar.addActionListener(new EnvioColetaListener(this));
        bnt_Enviar.addActionListener(new EnvioColetaListener(this));
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/email_go.png"));

    }

    public void setlisColeta(List<RequisicaoGetSet> lisreq, int id) {

        req = new RequisicaoGetSet();

        for (int i = 0; i < lisreq.size(); i++) {

            if (id == lisreq.get(i).getNumRequisicao()) {

                req = lisreq.get(i);
                break;
            }
        }

        model = (DefaultTableModel) tabela_coleta.getModel();
        model.setNumRows(0);

        for (int i = 0; i < req.getLisproduto().size(); i++) {

            req.getLisproduto().get(i).setquant(req.getQuantidade().get(i));
            model.addRow(new Object[]{req.getLisproduto().get(i).getCodigo(), req.getLisproduto().get(i).getNome(), req.getQuantidade().get(i)});

        }
        model2 = (DefaultTableModel) tabela_fornecedores.getModel();
        model2.setNumRows(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_coleta = new javax.swing.JTable();
        bnt_Enviar = new javax.swing.JButton();
        bnt_Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_fornecedores = new javax.swing.JTable();

        setClosable(true);
        setTitle("Envio de Coleta de Preço");

        tabela_coleta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Prod", "Produto", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_coleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_coletaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela_coleta);

        bnt_Enviar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bnt_Enviar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_Enviar.setText("Enviar");

        bnt_Cancelar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bnt_Cancelar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_Cancelar.setText("Cancelar");

        tabela_fornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fornecedor", "Email"
            }
        ));
        jScrollPane1.setViewportView(tabela_fornecedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(bnt_Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnt_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnt_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnt_Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_coletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_coletaMouseClicked

        if (evt.getClickCount() == 2) {
            model2 = (DefaultTableModel) tabela_fornecedores.getModel();

            model2.setNumRows(0);
            if (tabela_coleta.getSelectedRow() != -1) {
                ProdutoGetSet p = new ProdutoGetSet();
                String codProd = (String) model.getValueAt(tabela_coleta.getSelectedRow(), 0);
                for (int i = 0; i < req.getLisproduto().size(); i++) {

                    if (codProd.equals(req.getLisproduto().get(i).getCodigo())) {

                        p = req.getLisproduto().get(i);
                        break;

                    }
                }

                for (int i = 0; i < p.getF().size(); i++) {

                    model2.addRow(new Object[]{p.getF().get(i).getNome(), p.getF().get(i).getEmail()});

                }
            }
        }


    }//GEN-LAST:event_tabela_coletaMouseClicked
    public RequisicaoGetSet getColeta() {

        return req;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_Cancelar;
    private javax.swing.JButton bnt_Enviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela_coleta;
    private javax.swing.JTable tabela_fornecedores;
    // End of variables declaration//GEN-END:variables
}
