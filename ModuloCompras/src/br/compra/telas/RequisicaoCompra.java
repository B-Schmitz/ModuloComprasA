package br.compra.telas;

import br.compra.dao.RequisicaoDao;
import br.compra.getset.ProdutoGetSet;
import br.compra.getset.RequisicaoGetSet;
import br.compra.listeners.RequisicaoListener;
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

public class RequisicaoCompra extends javax.swing.JInternalFrame {

    private RequisicaoGetSet req;

    private Principal principal;
    private AddProdutoRequisicao Addprod;
    private final DefaultTableModel model;
    private int codigo;

    public RequisicaoCompra() {
        initComponents();
        bnt_cadastrar.addActionListener(new RequisicaoListener(this));
        bnt_excluir.addActionListener(new RequisicaoListener(this));
        bnt_inserir.addActionListener(new RequisicaoListener(this));
        bnt_limpar.addActionListener(new RequisicaoListener(this));
        model = (DefaultTableModel) tabela_produto.getModel();
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/cart_add.png"));

        DataAtual();
        try {
            AtualizaCodigo();
        } catch (SQLException ex) {
            Logger.getLogger(RequisicaoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void DataAtual() {
        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        txt_data.setText(df.format(hoje));
    }

    public final void AtualizaCodigo() throws SQLException {
        req = new RequisicaoGetSet();
        codigo = RequisicaoDao.ReadUltimo();
        txt_requisicao.setText(Integer.toString(codigo + 1));
    }

    public void Remove() {
        model.removeRow(tabela_produto.getSelectedRow());
    }

    public RequisicaoGetSet getRequisicao() {

        req = new RequisicaoGetSet();

        req.setData(txt_data.getText());
        req.setSetor(txt_setor.getText());
        req.setChefe(txt_chefe.getText());
        req.setNumRequisicao(Integer.parseInt(txt_requisicao.getText()));
        req.setSolicitante(txt_solicitante.getText());
        req.setObservacoes(txt_observacao.getText());
        req.setPrioridade(comboBox_prioridade.getSelectedItem().toString());

        List<ProdutoGetSet> produto = new ArrayList<>();
        List<String> Quant = new ArrayList<>();
        int i = 0;
        int tam = tabela_produto.getRowCount();
        while (tam > i) {
            ProdutoGetSet p = new ProdutoGetSet();

            p.setCodigo((String) tabela_produto.getValueAt(i, 0));
            produto.add(p);

            Quant.add((String) tabela_produto.getValueAt(i, 2));
            i++;
        }
        req.setQuantidade(Quant);
        req.setLisproduto(produto);

        return req;
    }

    public void AddProduto(Principal principal, AddProdutoRequisicao Addprod) {

        this.Addprod = Addprod;
        this.principal = principal;
        Addprod.setReq(this);

    }

    public void AbreJanelaAdd() {
        Addprod.atualizaLista();
        principal.JanelaAddProd();
    }

    public void setlis(List<ProdutoGetSet> lis) {

        for (int i = 0; i < lis.size(); i++) {
            model.addRow(new Object[]{lis.get(i).getCodigo(), lis.get(i).getNome(), lis.get(i).getquant()});
        }
    }

    public void Limpar() {
        txt_chefe.setText(null);
        txt_setor.setText(null);
        txt_solicitante.setText(null);
        txt_observacao.setText(null);
        comboBox_prioridade.setSelectedIndex(0);
        model.setNumRows(0);

    }

    public boolean Verifica() {

        return !(model.getRowCount() == 0
                || txt_chefe.getText().trim().isEmpty()
                || txt_setor.getText().trim().isEmpty()
                || txt_solicitante.getText().trim().isEmpty());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        txt_solicitante = new javax.swing.JTextField();
        txt_setor = new javax.swing.JTextField();
        txt_requisicao = new javax.swing.JTextField();
        label_setor = new javax.swing.JLabel();
        label_numero_requisicao = new javax.swing.JLabel();
        label_data = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_produto = new javax.swing.JTable();
        bnt_excluir = new javax.swing.JButton();
        bnt_inserir = new javax.swing.JButton();
        label_solicitante = new javax.swing.JLabel();
        label_chefe = new javax.swing.JLabel();
        txt_chefe = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_observacao = new javax.swing.JTextArea();
        comboBox_prioridade = new javax.swing.JComboBox<>();
        label_prioridade = new javax.swing.JLabel();
        bnt_limpar = new javax.swing.JButton();
        bnt_cadastrar = new javax.swing.JButton();
        txt_data = new javax.swing.JTextField();
        label_newdata = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        jMenuItem1.setText("jMenuItem1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
        jScrollPane3.setViewportView(jTextArea1);

        setClosable(true);
        setTitle("Requisição de Compras");
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

        txt_requisicao.setEditable(false);

        label_setor.setText("Setor:");

        label_numero_requisicao.setText("Número Requisição:");

        label_data.setText("Data:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Solicitados"));

        tabela_produto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela_produto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela_produto);
        if (tabela_produto.getColumnModel().getColumnCount() > 0) {
            tabela_produto.getColumnModel().getColumn(0).setResizable(false);
            tabela_produto.getColumnModel().getColumn(2).setResizable(false);
        }

        bnt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/delete.png"))); // NOI18N
        bnt_excluir.setText("Excluir");

        bnt_inserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/add.png"))); // NOI18N
        bnt_inserir.setText("Inserir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bnt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(bnt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        label_solicitante.setText("Solicitante:");

        label_chefe.setText("Chefe:");

        txt_observacao.setColumns(20);
        txt_observacao.setRows(5);
        txt_observacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
        jScrollPane4.setViewportView(txt_observacao);

        comboBox_prioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixo", "Normal", "Alto" }));

        label_prioridade.setText("Prioridade:");

        bnt_limpar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_limpar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_limpar.setText("Limpar");

        bnt_cadastrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_cadastrar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_cadastrar.setText("Cadastrar");

        txt_data.setEditable(false);
        txt_data.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataFocusLost(evt);
            }
        });
        txt_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataKeyPressed(evt);
            }
        });

        label_newdata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/date_edit.png"))); // NOI18N
        label_newdata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_newdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newdataMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_numero_requisicao)
                                    .addComponent(label_solicitante))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_requisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_solicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_setor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_setor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_chefe)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_chefe)))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_data)
                                    .addComponent(label_prioridade))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_data)
                                    .addComponent(comboBox_prioridade, 0, 75, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_newdata)
                                .addGap(74, 74, 74))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnt_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_numero_requisicao)
                    .addComponent(txt_requisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_setor)
                    .addComponent(comboBox_prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_prioridade))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_data)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_solicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_solicitante)
                        .addComponent(label_chefe)
                        .addComponent(txt_chefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_newdata))
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnt_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void label_newdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newdataMouseClicked
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo alterar a data atual?", "Alterar Data", 0);
        if (op == 0) {
            txt_data.setEditable(true);
            txt_data.requestFocus();
        }
    }//GEN-LAST:event_label_newdataMouseClicked

    private void txt_dataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_requisicao.grabFocus();
        }
    }//GEN-LAST:event_txt_dataKeyPressed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Limpar();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_cadastrar;
    private javax.swing.JButton bnt_excluir;
    private javax.swing.JButton bnt_inserir;
    private javax.swing.JButton bnt_limpar;
    private javax.swing.JComboBox<String> comboBox_prioridade;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label_chefe;
    private javax.swing.JLabel label_data;
    private javax.swing.JLabel label_newdata;
    private javax.swing.JLabel label_numero_requisicao;
    private javax.swing.JLabel label_prioridade;
    private javax.swing.JLabel label_setor;
    private javax.swing.JLabel label_solicitante;
    private javax.swing.JTable tabela_produto;
    private javax.swing.JTextField txt_chefe;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextArea txt_observacao;
    private javax.swing.JTextField txt_requisicao;
    private javax.swing.JTextField txt_setor;
    private javax.swing.JTextField txt_solicitante;
    // End of variables declaration//GEN-END:variables
}
