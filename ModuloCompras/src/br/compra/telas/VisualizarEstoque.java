package br.compra.telas;

import br.compra.dao.ProdutoDao;
import br.compra.getset.ProdutoGetSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class VisualizarEstoque extends javax.swing.JInternalFrame {

    private final ProdutoDao produtoDao = new ProdutoDao();
    private List<ProdutoGetSet> lisP;
    private DefaultTableModel modelp;
    private DefaultTableModel modelf;

    public VisualizarEstoque() {
        initComponents();
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/box_search.png"));

    }

    public void AtualizaLista() {

        lisP = produtoDao.Read();

        modelp = (DefaultTableModel) tabela_produtos.getModel();
        modelp.setNumRows(0);

        for (int i = 0; i < lisP.size(); i++) {

            modelp.addRow(new Object[]{lisP.get(i).getCodigo(), lisP.get(i).getNome(), lisP.get(i).getEst_max(), lisP.get(i).getEst_min(),
                lisP.get(i).getSaldo(), lisP.get(i).getPreco_un(), lisP.get(i).getPreco_compra(), lisP.get(i).getPreco_venda(), lisP.get(i).getData(), lisP.get(i).getCat().getNome()});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_fornecedores = new javax.swing.JTable();

        setClosable(true);
        setTitle("Estoque");

        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Estoque máx", "Estoque mín", "Saldo", "Preço unitário", "Preço compra", "Preço venda", "Data", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produtos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_produtos.getTableHeader().setReorderingAllowed(false);
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela_produtos);
        if (tabela_produtos.getColumnModel().getColumnCount() > 0) {
            tabela_produtos.getColumnModel().getColumn(0).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(1).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(2).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(3).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(4).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(5).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(6).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(7).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(8).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(9).setResizable(false);
        }

        tabela_fornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fornecedor", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_fornecedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        if (evt.getClickCount() == 2) {
            modelf = (DefaultTableModel) tabela_fornecedores.getModel();

            if(tabela_produtos.getSelectedRow() != -1){
            modelf.setNumRows(0);
            ProdutoGetSet p = new ProdutoGetSet();
            String codProd = (String) modelp.getValueAt(tabela_produtos.getSelectedRow(), 0);
            for (int i = 0; i < lisP.size(); i++) {

                if (codProd.equals(lisP.get(i).getCodigo())) {

                    p = lisP.get(i);
                    break;

                }

            }

            for (int i = 0; i < p.getF().size(); i++) {

                modelf.addRow(new Object[]{p.getF().get(i).getNome(), p.getF().get(i).getEmail()});

            }
            }

        }
    }//GEN-LAST:event_tabela_produtosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela_fornecedores;
    private javax.swing.JTable tabela_produtos;
    // End of variables declaration//GEN-END:variables
}
