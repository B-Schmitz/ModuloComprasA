package br.compra.telas;

import br.compra.getset.UsuarioGetSet;
import br.compra.listeners.UsuarioListener;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CadastrarUsuario extends javax.swing.JFrame {

    private UsuarioGetSet usuario;
    private final ImageIcon icone;

    public CadastrarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        bnt_cadastrar.addActionListener(new UsuarioListener(this));
        bnt_limpar.addActionListener(new UsuarioListener(this));
        icone = new ImageIcon("src/br/compra/icones/user_add.png");
        this.setIconImage(icone.getImage());

    }

    public UsuarioGetSet getUsuario() {

        usuario = new UsuarioGetSet();
        usuario.setUsuario(txt_usuario.getText());
        usuario.setSenha(txt_senha.getText());
        usuario.setEmail(txt_email.getText());
        usuario.setTipo(combo_box.getSelectedItem().toString());

        return usuario;

    }

    public void Limpar() {
        txt_usuario.setText(null);
        txt_email.setText(null);
        txt_senha.setText(null);
        txt_confirmar_senha.setText(null);
        combo_box.setSelectedIndex(0);
    }

    public boolean Verifica() {
        return !(txt_usuario.getText().trim().isEmpty()
                || txt_email.getText().trim().isEmpty()
                || txt_senha.getText().trim().isEmpty()
                || txt_confirmar_senha.getText().trim().isEmpty());
    }

    public boolean VerificaSenha() {
        return (txt_senha.getText().equals(txt_confirmar_senha.getText()));
    }

    public void AlertaTexto() throws InterruptedException {
        txt_usuario.setBackground(Color.RED);
        txt_usuario.setForeground(Color.WHITE);
    }

    public void AlertaTextoSenha() throws InterruptedException {
        txt_senha.setBackground(Color.RED);
        txt_senha.setForeground(Color.WHITE);
        txt_confirmar_senha.setBackground(Color.RED);
        txt_confirmar_senha.setForeground(Color.WHITE);
    }

    public void NormalizaTexto() throws InterruptedException {
        txt_usuario.setBackground(Color.WHITE);
        txt_usuario.setForeground(Color.BLACK);
        txt_senha.setBackground(Color.WHITE);
        txt_senha.setForeground(Color.BLACK);
        txt_confirmar_senha.setBackground(Color.WHITE);
        txt_confirmar_senha.setForeground(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        label_logo = new javax.swing.JLabel();
        label_cadastrar_usuario = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        label_senha = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        txt_confirmar_senha = new javax.swing.JPasswordField();
        txt_usuario = new javax.swing.JTextField();
        label_tipo = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_usuario = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        combo_box = new javax.swing.JComboBox<>();
        label_confirmar_senha = new javax.swing.JLabel();
        bnt_limpar = new javax.swing.JButton();
        bnt_cadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        label_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/user.png"))); // NOI18N

        label_cadastrar_usuario.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        label_cadastrar_usuario.setForeground(new java.awt.Color(255, 255, 255));
        label_cadastrar_usuario.setText("Cadastrar Usuário");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(label_logo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_cadastrar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(label_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_cadastrar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        label_senha.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        label_senha.setForeground(new java.awt.Color(255, 255, 255));
        label_senha.setText("Senha");

        txt_senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_senhaFocusGained(evt);
            }
        });

        txt_confirmar_senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_confirmar_senhaFocusGained(evt);
            }
        });

        txt_usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usuarioFocusGained(evt);
            }
        });

        label_tipo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        label_tipo.setForeground(new java.awt.Color(255, 255, 255));
        label_tipo.setText("Tipo");

        label_email.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText("Email");

        label_usuario.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        label_usuario.setForeground(new java.awt.Color(255, 255, 255));
        label_usuario.setText("Usúario");

        combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "N" }));

        label_confirmar_senha.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        label_confirmar_senha.setForeground(new java.awt.Color(255, 255, 255));
        label_confirmar_senha.setText("Confirmar Senha");

        bnt_limpar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bnt_limpar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_limpar.setText("Limpar");

        bnt_cadastrar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bnt_cadastrar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_cadastrar.setText("Cadastrar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnt_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_confirmar_senha)
                            .addComponent(label_senha)
                            .addComponent(label_tipo)
                            .addComponent(label_email)
                            .addComponent(label_usuario))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(txt_confirmar_senha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(combo_box, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_senha)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_confirmar_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_confirmar_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnt_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_senhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_senhaFocusGained
        txt_senha.setBackground(Color.WHITE);
        txt_senha.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_senhaFocusGained

    private void txt_confirmar_senhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_confirmar_senhaFocusGained
        txt_confirmar_senha.setBackground(Color.WHITE);
        txt_confirmar_senha.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_confirmar_senhaFocusGained

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Limpar();
    }//GEN-LAST:event_formWindowClosed

    private void txt_usuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFocusGained
        txt_usuario.setBackground(Color.WHITE);
        txt_usuario.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_usuarioFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarUsuario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_cadastrar;
    private javax.swing.JButton bnt_limpar;
    private javax.swing.JComboBox<String> combo_box;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel label_cadastrar_usuario;
    private javax.swing.JLabel label_confirmar_senha;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_senha;
    private javax.swing.JLabel label_tipo;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JPasswordField txt_confirmar_senha;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

}
