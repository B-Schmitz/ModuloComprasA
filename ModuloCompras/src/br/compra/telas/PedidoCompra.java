package br.compra.telas;

import br.compra.dao.PedidoDao;
import br.compra.getset.ColetaGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.getset.PedidoGetSet;
import br.compra.getset.PedidoItemGetSet;
import br.compra.getset.ProdutoGetSet;
import br.compra.listeners.PedidoListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class PedidoCompra extends javax.swing.JInternalFrame {

    private final DefaultTableModel model;
    private Double soma = 0.0;
    private PedidoDao pedidoDao;
    private PedidoGetSet pedido;
    private int codigo;

    public PedidoCompra() {
        initComponents();
        bnt_cadastrar.addActionListener(new PedidoListener(this));
        bnt_editar.addActionListener(new PedidoListener(this));
        bnt_excluir.addActionListener(new PedidoListener(this));
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/cart_full.png"));
        DataAtual();
        try {
            AtualizaCodigo();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        model = (DefaultTableModel) tabela_produto.getModel();
        setSoma();

    }

    private void DataAtual() {
        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        txt_data.setText(df.format(hoje));
    }

    public final void AtualizaCodigo() throws SQLException {
        pedidoDao = new PedidoDao();
        pedido = new PedidoGetSet();
        codigo = pedidoDao.ReadUltimo();
        txt_numero_pedido.setText(Integer.toString(codigo + 1));
    }

    public void setPedido(ColetaGetSet c) {

        model.addRow(new Object[]{c.getP().getCodigo(), c.getP().getNome(), c.getQuantidade(), c.getValorEstimado(), c.getDataPrevista(), c.getF().getNome(), c.getF().getCodigo()});

        setSoma();

    }

    public void editar() {

        if (tabela_produto.getSelectedRow() != -1) {
            int quant = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade desejada!"));
            model.setValueAt(quant, tabela_produto.getSelectedRow(), 2);
        }

    }

    public void setSoma() {
        soma = 0.0;
        if (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {

                soma += (Double) model.getValueAt(i, 3);

            }
        }
        lab_total.setText(String.valueOf(soma));
    }

    public void remove() {
        if (tabela_produto.getSelectedRow() != -1) {
            model.removeRow(tabela_produto.getSelectedRow());
        }
        setSoma();
    }

    public PedidoGetSet getPedido() {
        pedido = new PedidoGetSet();
        List<PedidoItemGetSet> pItem = new ArrayList<>();

        pedido.setIdPedidoCompra(Integer.parseInt(txt_numero_pedido.getText()));
        pedido.setData(txt_data.getText());
        pedido.setValor_estimado(Double.valueOf(lab_total.getText()));

        for (int i = 0; i < model.getRowCount(); i++) {

            List<FornecedorGetSet> lisf = new ArrayList<>();
            PedidoItemGetSet pi = new PedidoItemGetSet();
            ProdutoGetSet prod = new ProdutoGetSet();
            FornecedorGetSet forn = new FornecedorGetSet();

            prod.setCodigo((String) model.getValueAt(i, 0));
            prod.setNome((String) model.getValueAt(i, 1));
            pi.setQuantidade((Integer) model.getValueAt(i, 2));
            pi.setPreco((Double) model.getValueAt(i, 3));
            pi.setDataPrevista((String) model.getValueAt(i, 4));
            forn.setCodigo((String) model.getValueAt(i, 6));
            pi.setPrecoUni(pi.getPreco()/pi.getQuantidade());

            lisf.add(forn);
            prod.setF(lisf);

            pi.setP(prod);
            pItem.add(pi);
        }

        pedido.setpItem(pItem);

        return pedido;
    }

    public void Limpar() {
        model.setNumRows(0);
    }

    public boolean Verifica() {
        return (model.getRowCount() > 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_numero_pedido = new javax.swing.JTextField();
        label_numero_pedido = new javax.swing.JLabel();
        label_data = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_produto = new javax.swing.JTable();
        bnt_editar = new javax.swing.JButton();
        bnt_excluir = new javax.swing.JButton();
        label_valor_estimado = new javax.swing.JLabel();
        lab_total = new javax.swing.JLabel();
        bnt_cadastrar = new javax.swing.JButton();
        label_newdata = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Pedido de Compras");

        txt_numero_pedido.setEditable(false);

        label_numero_pedido.setText("Númedo Pedido:");

        label_data.setText("Data:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Solicitados"));

        tabela_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Prod", "Produto", "Quantidade", "Preço", "Data de Entrega", "Fornecedor", "idFornecedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela_produto);
        if (tabela_produto.getColumnModel().getColumnCount() > 0) {
            tabela_produto.getColumnModel().getColumn(0).setResizable(false);
            tabela_produto.getColumnModel().getColumn(1).setResizable(false);
            tabela_produto.getColumnModel().getColumn(2).setResizable(false);
            tabela_produto.getColumnModel().getColumn(3).setResizable(false);
            tabela_produto.getColumnModel().getColumn(4).setResizable(false);
            tabela_produto.getColumnModel().getColumn(5).setResizable(false);
            tabela_produto.getColumnModel().getColumn(6).setResizable(false);
        }

        bnt_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/pencil.png"))); // NOI18N
        bnt_editar.setText("Editar");

        bnt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/delete.png"))); // NOI18N
        bnt_excluir.setText("Excluir");

        label_valor_estimado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label_valor_estimado.setText("Total:");

        lab_total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lab_total.setText("_____");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_valor_estimado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lab_total)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bnt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(bnt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(271, 271, 271))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_valor_estimado)
                    .addComponent(lab_total))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(bnt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bnt_cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        bnt_cadastrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_cadastrar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_cadastrar.setText("Cadastar");
        bnt_cadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bnt_cadastrar.setBorderPainted(false);
        bnt_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        label_newdata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/date_edit.png"))); // NOI18N
        label_newdata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_newdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newdataMouseClicked(evt);
            }
        });
        label_newdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                label_newdataKeyPressed(evt);
            }
        });

        txt_data.setEditable(false);
        txt_data.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_numero_pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_numero_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_data)
                                .addGap(18, 18, 18)
                                .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_newdata))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_data)
                        .addComponent(txt_numero_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_numero_pedido)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_newdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_newdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newdataMouseClicked
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo alterar a data atual?", "Alterar Data", 0);
        if (op == 0) {
            txt_data.setEditable(true);
            txt_data.requestFocus();
        }
    }//GEN-LAST:event_label_newdataMouseClicked

    private void label_newdataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_newdataKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_numero_pedido.grabFocus();
        }
    }//GEN-LAST:event_label_newdataKeyPressed

    private void txt_dataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataFocusLost
        Date data = null;
        String dataTexto = txt_data.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal = GregorianCalendar.getInstance();

        if (dataTexto.equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso definir uma data válida", "Data vazia", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/date_error.png"));
            DataAtual();
        } else if (!dataTexto.endsWith(cal.get(Calendar.YEAR) + "")) {
            JOptionPane.showMessageDialog(null, "É preciso definir uma data válida", "Data incorreta", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/date_error.png"));
            DataAtual();

        } else {

            try {
                format.setLenient(false);
                data = format.parse(dataTexto);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "É preciso definir uma data válida", "Data incorreta", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/date_error.png"));
                DataAtual();
            }
        }

        txt_data.setEditable(false);

    }//GEN-LAST:event_txt_dataFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_cadastrar;
    private javax.swing.JButton bnt_editar;
    private javax.swing.JButton bnt_excluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab_total;
    private javax.swing.JLabel label_data;
    private javax.swing.JLabel label_newdata;
    private javax.swing.JLabel label_numero_pedido;
    private javax.swing.JLabel label_valor_estimado;
    private javax.swing.JTable tabela_produto;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_numero_pedido;
    // End of variables declaration//GEN-END:variables

    public void setColeta(ColetaGetSet c) {

    }
}
