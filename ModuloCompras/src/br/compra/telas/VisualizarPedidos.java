package br.compra.telas;

import br.compra.dao.PedidoDao;
import br.compra.getset.PedidoGetSet;
import br.compra.listeners.ConsultarPedidosListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class VisualizarPedidos extends javax.swing.JInternalFrame {

    private List<PedidoGetSet> lisP;
    private final PedidoDao pedidoDao = new PedidoDao();

    private DefaultTableModel modelp;
    private DefaultTableModel modelf;

    public VisualizarPedidos() {
        initComponents();

        btn_baixa.addActionListener(new ConsultarPedidosListener(this));
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/search_field.png"));
    }

    public PedidoGetSet Baixa() {

        PedidoGetSet p = new PedidoGetSet();
        if (tabela_Pedido.getSelectedRow() != -1) {

            for (int i = 0; i < lisP.size(); i++) {

                if (lisP.get(i).getIdPedidoCompra() == modelp.getValueAt(tabela_Pedido.getSelectedRow(), 0)) {

                    p = lisP.get(i);
                    break;

                }

            }

        }
        return p;
    }

    public void AtualizaTabela() {
        lisP = new ArrayList<>();
        lisP = pedidoDao.read(lisP);

        modelp = (DefaultTableModel) tabela_Pedido.getModel();
        modelf = (DefaultTableModel) tabela_ProdXForn.getModel();
        modelp.setNumRows(0);
        modelf.setNumRows(0);

        for (int i = 0; i < lisP.size(); i++) {

            modelp.addRow(new Object[]{lisP.get(i).getIdPedidoCompra(), lisP.get(i).getData(), lisP.get(i).getValor_estimado()});

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_ProdXForn = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_Pedido = new javax.swing.JTable();
        btn_baixa = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consultar Pedido");

        tabela_ProdXForn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Preço", "Data prevista de entrega", "Fornecedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_ProdXForn.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_ProdXForn);
        if (tabela_ProdXForn.getColumnModel().getColumnCount() > 0) {
            tabela_ProdXForn.getColumnModel().getColumn(0).setResizable(false);
            tabela_ProdXForn.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabela_ProdXForn.getColumnModel().getColumn(1).setResizable(false);
            tabela_ProdXForn.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabela_ProdXForn.getColumnModel().getColumn(2).setResizable(false);
            tabela_ProdXForn.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabela_ProdXForn.getColumnModel().getColumn(3).setResizable(false);
            tabela_ProdXForn.getColumnModel().getColumn(4).setResizable(false);
            tabela_ProdXForn.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        tabela_Pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do pedido", "Data do pedido", "Preço total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_Pedido.getTableHeader().setReorderingAllowed(false);
        tabela_Pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_PedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_Pedido);
        if (tabela_Pedido.getColumnModel().getColumnCount() > 0) {
            tabela_Pedido.getColumnModel().getColumn(0).setResizable(false);
            tabela_Pedido.getColumnModel().getColumn(1).setResizable(false);
            tabela_Pedido.getColumnModel().getColumn(2).setResizable(false);
        }

        btn_baixa.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btn_baixa.setForeground(new java.awt.Color(51, 51, 55));
        btn_baixa.setText("Dar baixa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btn_baixa, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_baixa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_PedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_PedidoMouseClicked

        modelf = (DefaultTableModel) tabela_ProdXForn.getModel();
        if (evt.getClickCount() == 2) {
            modelf.setNumRows(0);
            PedidoGetSet ped = new PedidoGetSet();
            System.out.println("tstee: " + lisP.size());
            for (int i = 0; i < lisP.size(); i++) {

                if (modelp.getValueAt(tabela_Pedido.getSelectedRow(), 0).equals(lisP.get(i).getIdPedidoCompra())) {

                    ped = lisP.get(i);
                    break;
                }

            }
            for (int i = 0; i < ped.getpItem().size(); i++) {

                modelf.addRow(new Object[]{ped.getpItem().get(i).getP().getNome(), ped.getpItem().get(i).getQuantidade(), ped.getpItem().get(i).getPreco(), ped.getpItem().get(i).getDataPrevista(),
                    ped.getpItem().get(i).getP().getF().get(0).getNome()});

            }

        }
    }//GEN-LAST:event_tabela_PedidoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_baixa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela_Pedido;
    private javax.swing.JTable tabela_ProdXForn;
    // End of variables declaration//GEN-END:variables
}
