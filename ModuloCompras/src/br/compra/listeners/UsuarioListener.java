package br.compra.listeners;

import br.compra.dao.UsuarioDao;
import br.compra.getset.UsuarioGetSet;
import br.compra.telas.CadastrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class UsuarioListener implements ActionListener {

    private final CadastrarUsuario cadastrarUsuario;
    private UsuarioGetSet usuario;
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final JPasswordField pwd = new JPasswordField(10);
    private String senha;

    public UsuarioListener(CadastrarUsuario cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Cadastrar")) {

            if (cadastrarUsuario.Verifica()) {
                try {
                    if (cadastrarUsuario.VerificaSenha()) {
                        usuario = cadastrarUsuario.getUsuario();
                        try {
                            if (!usuarioDao.isRegistro(usuario)) {
                                pwd.setEchoChar('*');
                                JOptionPane.showMessageDialog(null, pwd, "É necessário a senha de administrador", 1);
                                senha = new String(pwd.getPassword());
                                if (senha.equals("admin")) {
                                    pwd.setText(null);
                                    usuario = cadastrarUsuario.getUsuario();
                                    usuarioDao.Insert(usuario);
                                    cadastrarUsuario.Limpar();
                                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro concluído", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/br/compra/icones/add.png"));
                                    cadastrarUsuario.NormalizaTexto();
                                    cadastrarUsuario.dispose();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Senha de administrador incorreta", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Nome de usuário já cadastrado", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                                cadastrarUsuario.AlertaTexto();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ProdutoListener.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UsuarioListener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "As senhas não são iguais", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                        cadastrarUsuario.AlertaTextoSenha();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(UsuarioListener.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para efetuar o cadastro", "Cadastro falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
            }
        }

        if (e.getActionCommand()
                .equals("Limpar")) {
            cadastrarUsuario.Limpar();
        }

    }

}
