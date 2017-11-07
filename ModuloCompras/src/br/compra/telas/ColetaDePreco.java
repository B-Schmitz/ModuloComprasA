package br.compra.telas;

import br.compra.getset.ColetaGetSet;
import br.compra.listeners.ColetaPrecoListener;
import br.compra.xls.Lexls;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class ColetaDePreco extends javax.swing.JInternalFrame {

    private File selFile;
    private String LocalAquivos;
    private final DefaultListModel dl = new DefaultListModel();
    private final Lexls ler = new Lexls();
    private List<ColetaGetSet> lisColta;
    private DefaultTableModel modelC;
    private DefaultTableModel modelP;
    private Principal p;
    private List<String> codProd;
    private List<String> nomeProd;
    private final List<ColetaGetSet> c = new ArrayList<>();

    public ColetaDePreco() {
        initComponents();
        btn_buscar.addActionListener(new ColetaPrecoListener(this));
        btn_gerar.addActionListener(new ColetaPrecoListener(this));
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/money_dollar.png"));
    }

    public void Abre() {

        dl.clear();
        LocalAquivos = NomeLocal();

        txt_Caminho.setText(LocalAquivos);
        ProcuraArqTxt();
        lisColta = ler.ler(dl, LocalAquivos);

        Addprod();

    }

    public void Addprod() {

        modelC = (DefaultTableModel) tabela_coleta.getModel();
        modelP = (DefaultTableModel) tabela_produto.getModel();
        modelC.setNumRows(0);
        modelP.setNumRows(0);

        codProd = new ArrayList<>();
        nomeProd = new ArrayList<>();

        for (int i = 0; i < lisColta.size(); i++) {

            if (!codProd.contains(lisColta.get(i).getP().getCodigo())) {
                codProd.add(lisColta.get(i).getP().getCodigo());
                nomeProd.add(lisColta.get(i).getP().getNome());

            }

        }

        for (int i = 0; i < codProd.size(); i++) {

            modelP.addRow(new Object[]{codProd.get(i), nomeProd.get(i)});

        }

    }

    private void ProcuraArqTxt() {

        File[] files = new File(LocalAquivos).listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {

                if (name.endsWith("xlsx")) {

                    System.out.println("nome: " + name);
                    dl.addElement(name);
                    return true;
                } else {
                    return false;
                }
            }
        });

    }

    public void fecha() {

        dispose();

    }

    private String NomeLocal() {
        JFileChooser fc = new JFileChooser();
        //Define que apenar diretórios podem ser selecionados
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //Exibe o diálogo. Deve ser passado por parâmetro o JFrame de origem.
        fc.showOpenDialog(this);
        //Captura o objeto File que representa o diretório selecionado.
        selFile = fc.getSelectedFile();
        //Mostra o caminho do diretório
        return selFile.getAbsolutePath();
    }

    public void geraPedido() {

        ColetaGetSet col = new ColetaGetSet();

        if (tabela_coleta.getSelectedRow() != -1) {
            for (int i = 0; i < lisColta.size(); i++) {

                if (c.get(i).getF().getNome().equals(modelC.getValueAt(tabela_coleta.getSelectedRow(), 3))) {
                    col = c.get(i);
                    modelC.setNumRows(0);
                    break;
                }
            }
        }

        for (int i = 0; i < modelP.getRowCount(); i++) {

            if (modelP.getValueAt(i, 0).equals(col.getP().getCodigo())) {

                modelP.removeRow(i);

            }

        }
        p.IniciaPedido(col);

    }

    public void setPrincipal(Principal p) {

        this.p = p;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_Caminho = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_coleta = new javax.swing.JTable();
        btn_gerar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_produto = new javax.swing.JTable();

        jScrollPane2.setViewportView(jEditorPane1);

        setClosable(true);
        setTitle("Coleta de Preço");

        jLabel1.setText("Selecione a pasta:");

        btn_buscar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(51, 51, 55));
        btn_buscar.setText("Buscar");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 55));
        jLabel2.setText("Lista ordenada com os melhores preços, do melhor para o pior");

        txt_Caminho.setEditable(false);

        tabela_coleta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantidade", "Preço por unidade", "Total", "Fornecedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_coleta);

        btn_gerar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btn_gerar.setForeground(new java.awt.Color(51, 51, 55));
        btn_gerar.setText("Gerar pedido de compra");

        tabela_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do produto", "Produto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela_produto);
        if (tabela_produto.getColumnModel().getColumnCount() > 0) {
            tabela_produto.getColumnModel().getColumn(0).setResizable(false);
            tabela_produto.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(btn_buscar)
                                .addGap(49, 49, 49)
                                .addComponent(txt_Caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(btn_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Caminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtoMouseClicked

        if (evt.getClickCount() == 2) {
            modelC.setNumRows(0);

            if (tabela_produto.getSelectedRow() != -1) {
                String codP = (String) modelP.getValueAt(tabela_produto.getSelectedRow(), 0);

                c.clear();
                for (int i = 0; i < lisColta.size(); i++) {

                    if (codP.equals(lisColta.get(i).getP().getCodigo())) {

                        c.add(lisColta.get(i));

                    }

                }
                Collections.sort(c, (Object o1, Object o2) -> {
                    ColetaGetSet c1 = (ColetaGetSet) o1;
                    ColetaGetSet c2 = (ColetaGetSet) o2;

                    return c1.getValorEstimado() < c2.getValorEstimado() ? -1 : (c1.getValorEstimado() > c2.getValorEstimado() ? +1 : 0);
                });

                for (int i = 0; i < c.size(); i++) {
                    modelC.addRow(new Object[]{c.get(i).getQuantidade(), c.get(i).getPreco_unitario(), c.get(i).getValorEstimado(), c.get(i).getF().getNome()});
                }
            }

        }

    }//GEN-LAST:event_tabela_produtoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_gerar;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela_coleta;
    private javax.swing.JTable tabela_produto;
    private javax.swing.JTextField txt_Caminho;
    // End of variables declaration//GEN-END:variables
}
