package com.ailmax.backend.external;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

import java.util.Base64;
import java.util.Properties;

public class SendMail {

 
	
	public String verifyMail(String mail,int code,String url) throws Exception {
		
		String encodedVerify="";
		String text=" Verifing your Ailmax account press the link below \n";
		if(code>1000) {
			encodedVerify=Base64.getEncoder().encodeToString((code+"").getBytes());
			text=text.concat(url+"/Verify?code="+encodedVerify);
			send(mail,text);
		}else {
			throw new Exception("Invalid Verification code");
		}
		
		System.out.print(encodedVerify);
		return encodedVerify;
	}
	
	private void send(String to,String Text) {
		
		final String from="smperformer@gmail.com";
		final String pass="Ailmax420";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        Session sc=Session.getInstance(prop,new javax.mail.Authenticator() {
        	 protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(from, pass);
             }
        });
        
        try {
        	
        	Message message=new MimeMessage(sc);
        	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        	message.setSubject("Verify");
        	message.setText(Text);
        	Transport.send(message);
        	System.out.println("done");
        	
        }catch(Exception e) {
        	
        	System.out.print(e.toString());	
        	
        	}
	}
	//used as sample purpose
	/*public static void main(String[] args) {
		SendMail sm=new SendMail();
		try {
			sm.verifyMail("iamsharma.178@gmail.com",4567, "www.Ailmax.com/value");
		}catch(Exception e) {
			System.out.print(e);
		}
	}*/
	
	
}
