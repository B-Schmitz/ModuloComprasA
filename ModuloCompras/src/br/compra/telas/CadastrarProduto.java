package br.compra.telas;

import br.compra.dao.CategoriaDao;
import br.compra.dao.ProdutoDao;
import br.compra.excecoes.Numeros;
import br.compra.getset.CategoriaGetSet;
import br.compra.getset.ProdutoGetSet;
import br.compra.listeners.ProdutoListener;
import java.awt.Color;
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

public class CadastrarProduto extends javax.swing.JInternalFrame {

    private ProdutoDao produtoDao;
    private Principal principal;
    private AlterarSaldo alterarSaldo;
    private ProdutoGetSet prod;
    private int codigo;

    public CadastrarProduto() {
        initComponents();
        bnt_cadastrar.addActionListener(new ProdutoListener(this));
        bnt_limpar.addActionListener(new ProdutoListener(this));
        btn_novo.addActionListener(new ProdutoListener(this));
        bnt_alterar_saldo.addActionListener(new ProdutoListener(this));
        txt_estoqueMax.setDocument(new Numeros());
        txt_estoqueMin.setDocument(new Numeros());
        txt_saldo.setDocument(new Numeros());
        txt_precoCompra.setDocument(new Numeros());
        txt_precoUnitario.setDocument(new Numeros());
        txt_precoVenda.setDocument(new Numeros());
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/box_closed.png"));

        DataAtual();
        try {
            AtualizaCodigo();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AlterarSaldo(Principal principal, AlterarSaldo alterarSaldo) {
        this.principal = principal;
        this.alterarSaldo = alterarSaldo;
    }

    public void JanelaAlterarSaldo() {
        alterarSaldo.AtualizaLista();
        principal.JanelaAlterarSaldo();
    }

    private void DataAtual() {
        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        txt_data.setText(df.format(hoje));
    }

    public final void AtualizaCodigo() throws SQLException {
        produtoDao = new ProdutoDao();
        prod = new ProdutoGetSet();
        codigo = produtoDao.ReadUltimo();
        txt_codigo.setText(Integer.toString(codigo + 1));
    }

    public ProdutoGetSet getproduto() {

        prod = new ProdutoGetSet();

        prod.setCodigo(txt_codigo.getText());
        prod.setData(txt_data.getText());
        prod.setEst_max(Integer.parseInt(txt_estoqueMax.getText()));
        prod.setEst_min(Integer.parseInt(txt_estoqueMin.getText()));
        prod.setquant("");
        prod.setNome(txt_nome.getText());
        prod.setPreco_compra(Float.parseFloat(txt_precoCompra.getText()));
        prod.setPreco_un(Float.parseFloat(txt_precoUnitario.getText()));
        prod.setPreco_venda(Float.parseFloat(txt_precoVenda.getText()));
        prod.setPreco_custo(Float.parseFloat(txt_precoCusto.getText()));
        prod.setSaldo(Integer.parseInt(txt_saldo.getText()));

        CategoriaGetSet cat = new CategoriaGetSet();
        cat.setNome(combo_categoria.getSelectedItem().toString());
        prod.setCat(cat);

        return prod;

    }

    public boolean UpdateProduto() throws InterruptedException {
        int op = JOptionPane.showConfirmDialog(null, "Deseja adicionar um novo saldo para este produto??", "Adicionar saldo", 0);
        if (op == 0) {
            int saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o saldo adicional", "Adicionar saldo", 1));
            txt_saldo.setText(Integer.toString(saldo));
            return true;
        } else {
            AlertaTexto();
        }
        return false;
    }

    public void setComboBox(List<CategoriaGetSet> lis) {
        combo_categoria.removeAllItems();
        for (int i = 0; i < lis.size(); i++) {

            combo_categoria.addItem(lis.get(i).getNome());
        }

    }

    public void Limpar() {
        txt_estoqueMax.setText(null);
        txt_estoqueMin.setText(null);
        txt_nome.setText(null);
        txt_precoCompra.setText(null);
        txt_precoUnitario.setText(null);
        txt_precoVenda.setText(null);
        txt_precoCusto.setText(null);
        txt_saldo.setText(null);
    }

    public boolean Verifica() {
        return !(txt_nome.getText().trim().isEmpty()
                || txt_estoqueMax.getText().trim().isEmpty()
                || txt_estoqueMin.getText().trim().isEmpty()
                || txt_precoCompra.getText().trim().isEmpty()
                || txt_precoUnitario.getText().trim().isEmpty()
                || txt_precoVenda.getText().trim().isEmpty()
                || txt_precoCusto.getText().trim().isEmpty()
                || txt_saldo.getText().trim().isEmpty());
    }

    public void AlertaTexto() throws InterruptedException {
        txt_nome.setBackground(Color.RED);
        txt_nome.setForeground(Color.WHITE);
    }

    public void NormalizaTexto() throws InterruptedException {
        txt_nome.setBackground(Color.WHITE);
        txt_nome.setForeground(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_estoqueMin = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        label_preco_compra = new javax.swing.JLabel();
        label_snome = new javax.swing.JLabel();
        label_preco_venda = new javax.swing.JLabel();
        label_est_max = new javax.swing.JLabel();
        label_saldo = new javax.swing.JLabel();
        label_est_min = new javax.swing.JLabel();
        label_codigo_produto = new javax.swing.JLabel();
        label_preco_unitario = new javax.swing.JLabel();
        txt_saldo = new javax.swing.JTextField();
        label_data = new javax.swing.JLabel();
        txt_precoUnitario = new javax.swing.JTextField();
        label_categoria = new javax.swing.JLabel();
        combo_categoria = new javax.swing.JComboBox<>();
        txt_precoCompra = new javax.swing.JTextField();
        txt_precoVenda = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_estoqueMax = new javax.swing.JTextField();
        btn_novo = new javax.swing.JButton();
        bnt_cadastrar = new javax.swing.JButton();
        bnt_limpar = new javax.swing.JButton();
        txt_data = new javax.swing.JTextField();
        label_newdata = new javax.swing.JLabel();
        bnt_alterar_saldo = new javax.swing.JButton();
        label_preco_custo = new javax.swing.JLabel();
        txt_precoCusto = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastrar Produto");
        setToolTipText("");
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

        txt_codigo.setEditable(false);

        label_preco_compra.setText("Preço Compra:");

        label_snome.setText("Nome:");

        label_preco_venda.setText("Preço Venda:");

        label_est_max.setText("Estoque Máx:");

        label_saldo.setText("Saldo:");

        label_est_min.setText("Estoque Min:");

        label_codigo_produto.setText("Código:");

        label_preco_unitario.setText("Preço Unitário:");

        label_data.setText("Data:");

        label_categoria.setText("Categoria:");

        combo_categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_categoriaMouseClicked(evt);
            }
        });

        txt_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomeFocusGained(evt);
            }
        });

        btn_novo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        btn_novo.setForeground(new java.awt.Color(51, 51, 55));
        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/category.png"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_novo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        bnt_cadastrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_cadastrar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_cadastrar.setText("Cadastrar");
        bnt_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        bnt_limpar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_limpar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_limpar.setText("Limpar");
        bnt_limpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        bnt_alterar_saldo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_alterar_saldo.setForeground(new java.awt.Color(51, 51, 55));
        bnt_alterar_saldo.setText("Alterar saldo");

        label_preco_custo.setText("Preço Custo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_snome)
                                .addGap(58, 58, 58)
                                .addComponent(txt_nome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_est_max)
                                        .addGap(23, 23, 23)
                                        .addComponent(txt_estoqueMax))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_preco_unitario)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_precoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                        .addComponent(label_est_min)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(label_saldo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_estoqueMin, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(txt_saldo)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_codigo_produto)
                        .addGap(54, 54, 54)
                        .addComponent(txt_codigo)
                        .addGap(18, 18, 18)
                        .addComponent(label_data)
                        .addGap(18, 18, 18)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_newdata)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_categoria)
                        .addGap(18, 18, 18)
                        .addComponent(combo_categoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_novo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnt_alterar_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnt_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label_preco_compra))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_preco_custo)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_precoCusto)
                            .addComponent(txt_precoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(label_preco_venda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_precoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_codigo_produto))
                    .addComponent(label_newdata)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_data)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(label_snome))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_estoqueMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_estoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_est_min))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(label_est_max)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_precoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_saldo))
                    .addComponent(txt_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(label_preco_unitario)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_precoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_preco_compra)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_preco_venda)
                                .addComponent(txt_precoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_preco_custo)
                    .addComponent(txt_precoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_categoria)
                    .addComponent(btn_novo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bnt_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bnt_alterar_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomeFocusGained
        txt_nome.setBackground(Color.WHITE);
        txt_nome.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_nomeFocusGained

    private void label_newdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newdataMouseClicked
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo alterar a data atual?", "Alterar Data", 0);
        if (op == 0) {
            txt_data.setEditable(true);
            txt_data.requestFocus();
        }
    }//GEN-LAST:event_label_newdataMouseClicked

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

    private void txt_dataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_codigo.grabFocus();
        }
    }//GEN-LAST:event_txt_dataKeyPressed

    private void combo_categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_categoriaMouseClicked
        CategoriaDao catDao = new CategoriaDao();
        List<CategoriaGetSet> lis = new ArrayList<>();

        lis = catDao.read(lis);
        setComboBox(lis);
    }//GEN-LAST:event_combo_categoriaMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Limpar();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_alterar_saldo;
    private javax.swing.JButton bnt_cadastrar;
    private javax.swing.JButton bnt_limpar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JComboBox<String> combo_categoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_categoria;
    private javax.swing.JLabel label_codigo_produto;
    private javax.swing.JLabel label_data;
    private javax.swing.JLabel label_est_max;
    private javax.swing.JLabel label_est_min;
    private javax.swing.JLabel label_newdata;
    private javax.swing.JLabel label_preco_compra;
    private javax.swing.JLabel label_preco_custo;
    private javax.swing.JLabel label_preco_unitario;
    private javax.swing.JLabel label_preco_venda;
    private javax.swing.JLabel label_saldo;
    private javax.swing.JLabel label_snome;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_estoqueMax;
    private javax.swing.JTextField txt_estoqueMin;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_precoCompra;
    private javax.swing.JTextField txt_precoCusto;
    private javax.swing.JTextField txt_precoUnitario;
    private javax.swing.JTextField txt_precoVenda;
    private javax.swing.JTextField txt_saldo;
    // End of variables declaration//GEN-END:variables

}
