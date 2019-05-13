package Login;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import bancoDeDados.Alerta;
import bancoDeDados.BancoDeDados;

public class VerificarAlertas implements Runnable {

	private BancoDeDados bd;
	private final String emailRemetente = "es2.2019.iscte";
	private final String emailPass = "es22019iscte";

	public VerificarAlertas(BancoDeDados bd) {
		this.bd = bd;
	}

	public void run() {
		while (true) {
			try {
				ArrayList<Alerta> alert = bd.verificarAlertas();
				if (alert != null) {
					for (Alerta alerta : alert) {
						String mensagem = "Limite Ultrapassado " + alerta.getDescricao();
						String assunto = "Alerta da variavel " + alerta.getNomeVariavel();

						if (alerta.getEmailUtilizador() != null && !alerta.getEmailUtilizador().isEmpty()) {
							// envia email para o utilizador, alerta destinado ao investigador
							sendEmail(alerta.getEmailUtilizador(), assunto, mensagem);
						} else {
							// envia email para email generico, alerta do sensor
							sendEmail(emailRemetente, assunto, mensagem);
						}

						JOptionPane.showMessageDialog(null, mensagem);

						bd.tornarAlertaVisto(alerta);
					}
				}

				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendEmail(String emailDestinatario, String Assunto, String corpoEmail) {
		try {

			String host = "smtp.gmail.com";
			String user = emailRemetente;
			String pass = emailPass;
			String to = emailDestinatario;
			String from = emailRemetente;
			String subject = Assunto;
			String messageText = corpoEmail;
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}