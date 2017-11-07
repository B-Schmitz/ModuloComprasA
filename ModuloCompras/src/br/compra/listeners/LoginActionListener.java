package br.compra.listeners;

import br.compra.dao.UsuarioDao;
import br.compra.getset.LoginGetSet;
import br.compra.getset.UsuarioGetSet;
import br.compra.telas.CadastrarUsuario;
import br.compra.telas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginActionListener implements ActionListener {

    private final Login login;
    private final UsuarioDao usuarioDao = new UsuarioDao();
    CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
    private LoginGetSet l;
    private UsuarioGetSet usuario;

    public LoginActionListener(Login login) {

        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Entrar")) {
            usuario = login.getUsuario();
            try {
                if (usuarioDao.isRegistro(usuario)) {
                    usuarioDao.Read(usuario);
                    if (login.Verifica(usuario)) {
                        login.CarregaPrincipal();
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta", "Login falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não cadastrado no sistema", "Login falhou", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(LoginActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getActionCommand().equals("Sair")) {
            System.exit(0);
        }
    }
}
