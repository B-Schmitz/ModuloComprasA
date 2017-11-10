package br.compra.telas;

import br.compra.dao.ProdutoDao;
import br.compra.getset.ProdutoGetSet;
import br.compra.listeners.AlterarSaldoListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlterarSaldo extends javax.swing.JInternalFrame {

    private final ProdutoDao produtoDao = new ProdutoDao();
    private ProdutoGetSet prod;

    public AlterarSaldo() {
        initComponents();
        bnt_alterar_saldo.addActionListener(new AlterarSaldoListener(this));
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/box_closed.png"));
        AtualizaLista();
    }

    public final void AtualizaLista() {

        List<ProdutoGetSet> lisP = produtoDao.Read();

        DefaultTableModel model = (DefaultTableModel) tabela_produtos.getModel();
        model.setNumRows(0);

        for (int i = 0; i < lisP.size(); i++) {

            model.addRow(new Object[]{lisP.get(i).getCodigo(), lisP.get(i).getNome(), lisP.get(i).getSaldo()});

        }
    }

    public void Alterar() {
        DefaultTableModel model = (DefaultTableModel) tabela_produtos.getModel();
        if (tabela_produtos.getSelectedRow() != -1) {
            prod = new ProdutoGetSet();
            prod.setSaldo(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o saldo adicional", "Adicionar saldo", 1)));
            prod.setNome(model.getValueAt(tabela_produtos.getSelectedRow(), 1).toString());
            produtoDao.Update(prod);
            AtualizaLista();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bnt_alterar_saldo = new javax.swing.JButton();
        jpanel_Produtos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Alterar Saldo");

        bnt_alterar_saldo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bnt_alterar_saldo.setForeground(new java.awt.Color(51, 51, 55));
        bnt_alterar_saldo.setText("Alterar Saldo");

        jpanel_Produtos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estoque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpanel_Produtos.setPreferredSize(new java.awt.Dimension(430, 340));

        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produtos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabela_produtos);
        if (tabela_produtos.getColumnModel().getColumnCount() > 0) {
            tabela_produtos.getColumnModel().getColumn(0).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(1).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanel_ProdutosLayout = new javax.swing.GroupLayout(jpanel_Produtos);
        jpanel_Produtos.setLayout(jpanel_ProdutosLayout);
        jpanel_ProdutosLayout.setHorizontalGroup(
            jpanel_ProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpanel_ProdutosLayout.setVerticalGroup(
            jpanel_ProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_ProdutosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanel_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(bnt_alterar_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jpanel_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnt_alterar_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_alterar_saldo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpanel_Produtos;
    private javax.swing.JTable tabela_produtos;
    // End of variables declaration//GEN-END:variables
}
