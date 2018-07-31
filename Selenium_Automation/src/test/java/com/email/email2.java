package com.email;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class email2 {
	
	
	public static void main(String[] args) {
		
	
	Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "25");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.prot", "25");

    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("sarowerny@gmail.com", "tanvirj9");
        }
    }
    );
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("sarowerqa@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sarowerqa@gmail.com"));
        message.setSubject("MAIL SUBJECT !");
        message.setText("MAIL BODY !");
        Transport.send(message);

    } catch (Exception e) {
      //  JOptionPane.showMessageDialog(null, e);
        e.printStackTrace();;
    }

}
}
