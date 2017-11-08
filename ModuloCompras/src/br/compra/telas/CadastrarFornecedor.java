package br.compra.telas;

import br.compra.dao.CategoriaDao;
import br.compra.dao.FornecedorDao;
import br.compra.getset.CategoriaGetSet;
import br.compra.getset.EnderecoGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.listeners.FornecedorListener;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;

public class CadastrarFornecedor extends javax.swing.JInternalFrame {

    private FornecedorDao fornecedorDao;
    private FornecedorGetSet forn;
    private EnderecoGetSet e;
    private int codigo;

    public CadastrarFornecedor() {
        initComponents();
        btn_limpar.addActionListener(new FornecedorListener(this));
        btn_cadastrar.addActionListener(new FornecedorListener(this));
        btn_novo.addActionListener(new FornecedorListener(this));
        this.setFrameIcon(new ImageIcon("src/br/compra/icones/lorry.png"));
        try {
            AtualizaCodigo();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public final void AtualizaCodigo() throws SQLException {
        fornecedorDao = new FornecedorDao();
        forn = new FornecedorGetSet();
        codigo = fornecedorDao.ReadUltimo();
        txt_codigo.setText(Integer.toString(codigo + 1));
    }

    public void setComboBox(List<CategoriaGetSet> lis) {
        combo_categoria.removeAllItems();
        for (int i = 0; i < lis.size(); i++) {

            combo_categoria.addItem(lis.get(i).getNome());

        }

    }

    public FornecedorGetSet getfornecedor() {

        forn = new FornecedorGetSet();
        e = new EnderecoGetSet();

        forn.setCNPJ(txt_cnpj.getText().replaceAll("[-,/,/.]", ""));
        forn.setCodigo(txt_codigo.getText());
        forn.setEmail(txt_email.getText());
        forn.setNome(txt_nome.getText());
        forn.setTelefone(txt_telefone.getText());

        CategoriaGetSet cat = new CategoriaGetSet();
        cat.setNome(combo_categoria.getSelectedItem().toString());
        forn.setCat(cat);

        e.setBairro(txt_bairro.getText());
        e.setCidade(txt_cidade.getText());
        e.setEstado(txt_estado.getText());
        e.setPais(txt_pais.getText());
        e.setRua(txt_rua.getText());
        e.setCEP(Integer.parseInt(txt_cep.getText()));

        forn.setE(e);

        return forn;

    }

    public boolean Verifica() {
        return !(txt_nome.getText().trim().isEmpty()
                || txt_cnpj.getText().replaceAll("[-,/,/.]", "").trim().isEmpty()
                || txt_telefone.getText().trim().isEmpty()
                || txt_email.getText().trim().isEmpty()
                || txt_pais.getText().trim().isEmpty()
                || txt_estado.getText().trim().isEmpty()
                || txt_cidade.getText().trim().isEmpty()
                || txt_bairro.getText().trim().isEmpty()
                || txt_rua.getText().trim().isEmpty()
                || txt_cep.getText().trim().isEmpty());
    }

    public void Limpar() {
        txt_nome.setText(null);
        txt_email.setText(null);
        txt_telefone.setText(null);
        txt_nome.setText(null);
        txt_cnpj.setText(null);
        txt_cnpj.setFocusLostBehavior(JFormattedTextField.PERSIST);
        txt_pais.setText(null);
        txt_estado.setText(null);
        txt_cidade.setText(null);
        txt_bairro.setText(null);
        txt_rua.setText(null);
        txt_cep.setText(null);
    }

    public void AlertaTexto() throws InterruptedException {
        txt_nome.setBackground(Color.RED);
        txt_nome.setForeground(Color.WHITE);
        txt_cnpj.setBackground(Color.RED);
        txt_cnpj.setForeground(Color.WHITE);
    }

    public void NormalizaTexto() throws InterruptedException {
        txt_nome.setBackground(Color.WHITE);
        txt_nome.setForeground(Color.BLACK);
        txt_cnpj.setBackground(Color.WHITE);
        txt_cnpj.setForeground(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jSpinner1 = new javax.swing.JSpinner();
        painel_principal = new javax.swing.JPanel();
        painel_endereco = new javax.swing.JPanel();
        label_pais = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        label_estado = new javax.swing.JLabel();
        txt_pais = new javax.swing.JTextField();
        label_cidade = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        txt_bairro = new javax.swing.JTextField();
        label_bairro = new javax.swing.JLabel();
        label_cep = new javax.swing.JLabel();
        txt_cep = new javax.swing.JTextField();
        label_rua = new javax.swing.JLabel();
        txt_rua = new javax.swing.JTextField();
        painel_fornecedor = new javax.swing.JPanel();
        label_nome = new javax.swing.JLabel();
        label_cnpj = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        label_telefone = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_cnpj = new javax.swing.JFormattedTextField();
        combo_categoria = new javax.swing.JComboBox<>();
        btn_novo = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        btn_cadastrar = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setTitle("Cadastrar Fornecedores");
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

        painel_endereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        label_pais.setText("País:");

        label_estado.setText("Estado:");

        label_cidade.setText("Cidade:");

        label_bairro.setText("Bairro:");

        label_cep.setText("CEP:");

        label_rua.setText("Rua:");

        javax.swing.GroupLayout painel_enderecoLayout = new javax.swing.GroupLayout(painel_endereco);
        painel_endereco.setLayout(painel_enderecoLayout);
        painel_enderecoLayout.setHorizontalGroup(
            painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_enderecoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_pais)
                    .addComponent(label_cidade)
                    .addComponent(label_estado)
                    .addComponent(label_bairro)
                    .addComponent(label_rua)
                    .addComponent(label_cep))
                .addGap(56, 56, 56)
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_rua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_pais, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_estado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cep))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        painel_enderecoLayout.setVerticalGroup(
            painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_enderecoLayout.createSequentialGroup()
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_pais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_estado)
                    .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_cidade)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_bairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_rua)
                    .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_cep))
                .addContainerGap())
        );

        painel_fornecedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        label_nome.setText("Nome:");

        label_cnpj.setText("CNPJ:");

        txt_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomeFocusGained(evt);
            }
        });

        label_telefone.setText("Telefone:");

        label_email.setText("Email:");

        label_codigo.setText("Código:");

        txt_codigo.setEditable(false);

        jLabel1.setText("Ramo:");

        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cnpjFocusGained(evt);
            }
        });

        combo_categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_categoriaMouseClicked(evt);
            }
        });

        btn_novo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        btn_novo.setForeground(new java.awt.Color(51, 51, 55));
        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/category.png"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_novo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout painel_fornecedorLayout = new javax.swing.GroupLayout(painel_fornecedor);
        painel_fornecedor.setLayout(painel_fornecedorLayout);
        painel_fornecedorLayout.setHorizontalGroup(
            painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_codigo)
                    .addComponent(label_nome)
                    .addComponent(label_email)
                    .addComponent(label_telefone)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(painel_fornecedorLayout.createSequentialGroup()
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_cnpj)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cnpj))
                    .addGroup(painel_fornecedorLayout.createSequentialGroup()
                        .addComponent(combo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_novo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_fornecedorLayout.setVerticalGroup(
            painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_cnpj)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_email)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_telefone)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_fornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_novo))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btn_limpar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        btn_limpar.setForeground(new java.awt.Color(51, 51, 55));
        btn_limpar.setText("Limpar");

        btn_cadastrar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(51, 51, 55));
        btn_cadastrar.setText("Cadastrar");

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addComponent(painel_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painel_endereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_endereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cnpjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpjFocusGained
        txt_cnpj.setBackground(Color.WHITE);
        txt_cnpj.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_cnpjFocusGained

    private void txt_nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomeFocusGained
        txt_nome.setBackground(Color.WHITE);
        txt_nome.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_nomeFocusGained

    private void combo_categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_categoriaMouseClicked
      
        atualizaCombo();
    }//GEN-LAST:event_combo_categoriaMouseClicked

    public void atualizaCombo(){
    CategoriaDao catDao = new CategoriaDao();
        List<CategoriaGetSet> lis = new ArrayList<>();

        lis = catDao.read(lis);
        setComboBox(lis);
}
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       Limpar();
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JComboBox<String> combo_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel label_bairro;
    private javax.swing.JLabel label_cep;
    private javax.swing.JLabel label_cidade;
    private javax.swing.JLabel label_cnpj;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_estado;
    private javax.swing.JLabel label_nome;
    private javax.swing.JLabel label_pais;
    private javax.swing.JLabel label_rua;
    private javax.swing.JLabel label_telefone;
    private javax.swing.JPanel painel_endereco;
    private javax.swing.JPanel painel_fornecedor;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pais;
    private javax.swing.JTextField txt_rua;
    private javax.swing.JTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
}
