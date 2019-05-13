/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */

package SendEmail;

/**
 *
 * @author Naveen
 */
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend {
	public EmailSend() {
		selectAlert();
	}

	public void sendEmail() {
		try {

			String host = "smtp.gmail.com";
			String user = "username";
			String pass = "pass";
			String to = "daniel.romao.leal.g@gmail.com";
			String from = "PedroAlmeida";
			String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
			String messageText = "Your Is Test Email : ";
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

	public void selectAlert() {
		String query = "SELECT * FROM alertas";
		System.out.println(query);

	}

	public static void main(String[] args) {
		EmailSend es = new EmailSend();
	}
}
