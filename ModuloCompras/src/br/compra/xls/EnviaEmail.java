package br.compra.xls;

import br.compra.getset.UsuarioGetSet;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EnviaEmail {

    private final String remetente = "mbnnnaasccimmetto@gmail.com";
    private final String senha = "mb-programer";
    private final String smtp = "Smtp.gmail.com";
    private final String nomeArquivo = "Coleta de preco.xls";
    private final String assunto = "Coleta de preço";

    private final MultiPartEmail email;

    public EnviaEmail() {

        email = new MultiPartEmail();
        configure();

    }

    private void configure() {

        email.setHostName(smtp);
        email.setSmtpPort(465);
        email.setDebug(true);
        email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
        email.setSSLOnConnect(true);
    }

    public void emailFornecedor(String msg, String file, String destinatario) {

        try {

            EmailAttachment anexo = new EmailAttachment();
            anexo.setPath(file); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)
            anexo.setDisposition(EmailAttachment.ATTACHMENT);

            anexo.setName(nomeArquivo);

            email.setFrom(remetente);
            email.setMsg(msg);
            email.setSubject(assunto);
            email.addTo(destinatario);

            email.attach(anexo);
            email.send();

        } catch (EmailException e) {
            e.getStackTrace();
        }

    }

    public void emailSenha(UsuarioGetSet user) {

        try {

            email.setFrom(remetente);
            email.setMsg("A sua senha é: " + user.getSenha());
            email.setSubject("Solicitação de senha");
            email.addTo(user.getEmail());

            email.send();

        } catch (EmailException e) {
            e.getStackTrace();
        }

    }

}
