package rnr.care.entities;

/*
 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author balha
 */
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*; 
public class Mail {
      public static void send(String from,String password,String to,String sub,String msg){  

        Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });  
          //String certificatesTrustStorePath = "<JAVA HOME>/jre/lib/security/cacerts";
//System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
          //compose message   
          
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub); 
           message.setText(msg);   
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
    
}