package br.compra.telas;

import br.compra.dao.UsuarioDao;
import br.compra.getset.UsuarioGetSet;
import br.compra.listeners.LoginActionListener;
import br.compra.xls.EnviaEmail;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private final LoginActionListener login = new LoginActionListener(this);
    private Principal principal;
    private UsuarioGetSet usuario;
    private EnviaEmail enviaEmail = new EnviaEmail();
    private final CadastrarUsuario cadastrar_usuario = new CadastrarUsuario();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final ImageIcon icone;
    private static String linha;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        btn_entrar.addActionListener(login);
        btn_sair.addActionListener(login);
        icone = new ImageIcon("src/br/compra/icones/logo.png");
        this.setIconImage(icone.getImage());
        txt_senha.grabFocus();
        try {
            ler();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_usuario.setText(linha);
    }

    public static void escrever(String user) throws IOException {
        String a = "usuario.txt";
        FileWriter fileWriter = new FileWriter(a);
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(user);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static void ler() throws IOException {
        FileReader fileReader = new FileReader("usuario.txt");
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                linha = bufferedReader.readLine();
            }
        }
    }

    public void CarregaPrincipal() throws IOException {
        escrever(txt_usuario.getText());
        principal = new Principal();
        principal.setVisible(true);
        principal.RecebeTipo(usuario.getTipo());
        dispose();
    }

    public UsuarioGetSet getUsuario() {
        usuario = new UsuarioGetSet();
        usuario.setUsuario(txt_usuario.getText());
        usuario.setSenha(txt_senha.getText());
        return usuario;
    }

    public boolean Verifica(UsuarioGetSet usuario) {
        return (txt_usuario.getText().equals(usuario.getUsuario()) && txt_senha.getText().equals(usuario.getSenha()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_usuario = new javax.swing.JTextField();
        btn_sair = new javax.swing.JButton();
        label_usuario = new javax.swing.JLabel();
        label_senha = new javax.swing.JLabel();
        btn_entrar = new javax.swing.JButton();
        label_criar_conta = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txt_senha = new javax.swing.JPasswordField();
        label_recuperar_senha = new javax.swing.JLabel();
        label_logo = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        label_modulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo Compras");
        setResizable(false);

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        btn_sair.setBackground(new java.awt.Color(255, 255, 255));
        btn_sair.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btn_sair.setForeground(new java.awt.Color(51, 51, 55));
        btn_sair.setText("Sair");
        btn_sair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_sair.setBorderPainted(false);
        btn_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        label_usuario.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        label_usuario.setForeground(new java.awt.Color(255, 255, 255));
        label_usuario.setText("              Usuário");

        label_senha.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        label_senha.setForeground(new java.awt.Color(255, 255, 255));
        label_senha.setText("               Senha");

        btn_entrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_entrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        btn_entrar.setForeground(new java.awt.Color(51, 51, 55));
        btn_entrar.setText("Entrar");
        btn_entrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_entrar.setBorderPainted(false);
        btn_entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        label_criar_conta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        label_criar_conta.setForeground(new java.awt.Color(255, 255, 255));
        label_criar_conta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/user_add.png"))); // NOI18N
        label_criar_conta.setText("Criar um novo usuário");
        label_criar_conta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_criar_conta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_criar_contaMouseClicked(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txt_senha.setText("admin");
        txt_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_senhaKeyPressed(evt);
            }
        });

        label_recuperar_senha.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        label_recuperar_senha.setForeground(new java.awt.Color(255, 255, 255));
        label_recuperar_senha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/key.png"))); // NOI18N
        label_recuperar_senha.setText("Recuperar senha");
        label_recuperar_senha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_recuperar_senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_recuperar_senhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_criar_conta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_recuperar_senha)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_senha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_usuario)
                            .addComponent(txt_senha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_criar_conta)
                    .addComponent(label_recuperar_senha)))
            .addComponent(jSeparator5)
        );

        label_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/logo.png"))); // NOI18N

        label_modulo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        label_modulo.setForeground(new java.awt.Color(255, 255, 255));
        label_modulo.setText("Módulo Compras");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_modulo)
                            .addComponent(label_logo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_modulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_criar_contaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_criar_contaMouseClicked
        cadastrar_usuario.setVisible(true);
    }//GEN-LAST:event_label_criar_contaMouseClicked

    private void txt_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_entrar.doClick();
        }
    }//GEN-LAST:event_txt_senhaKeyPressed

    private void label_recuperar_senhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_recuperar_senhaMouseClicked
        usuario = new UsuarioGetSet();
        String result = JOptionPane.showInputDialog(null, "Informe o email da sua conta ou nome de usuário", "Recuperar senha", 1);
        try {
            if (!result.equals("")) {
                usuario.setEmail(result);
                usuario.setUsuario(result);
                try {
                    if (usuarioDao.isRegistro(usuario)) {
                        usuarioDao.Read(usuario);
                        JOptionPane.showMessageDialog(null, "Pressione OK, e aguarde uns instantes", "Aguarde", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/accept.png"));
                        enviaEmail.emailSenha(usuario);
                        JOptionPane.showMessageDialog(null, "Email de recuperação de senha enviado com sucesso", "Recuperar senha concluído", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/accept.png"));

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não cadastrado no sistema", "Recuperar senha falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo vazio!", "Recuperar senha falhou", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/exclamation/add.png"));
            }
        } catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_label_recuperar_senhaMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel label_criar_conta;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_modulo;
    private javax.swing.JLabel label_recuperar_senha;
    private javax.swing.JLabel label_senha;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

}
