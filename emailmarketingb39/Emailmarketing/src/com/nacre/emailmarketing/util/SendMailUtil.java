//Author: Satyajeet and Amit
package com.nacre.emailmarketing.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.nacre.emailmarketing.dto.SendMailDTO;

public class SendMailUtil {

	private static String userName;
	private static String password;
	private static String sendingHost;
	private static String receivingHost;
	private String from;
	private String to;
	private String subject;
	private String text;
	private int sendingPort;

	

	public Integer  sendGmail(SendMailDTO dto, Integer productId)
	{
		InputStream inputStream = SendMailUtil.class.getClassLoader().getResourceAsStream("mail.properties");	
		System.out.println(inputStream);
		Properties props = new Properties();
		try {
			props.load(inputStream);
			userName = props.getProperty("userName");
			password = props.getProperty("password");
			sendingHost = props.getProperty("sendingHost");
			receivingHost = props.getProperty("receivingHost");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// This will send mail from -->sender@gmail.com to -->receiver@gmail.com
		this.from = userName;
		this.subject = "New Arrival of  "+dto.getProductName()+" "+dto.getProductType();
		this.text = dto.getProductName()+" of Price Rs."+dto.getPrice();
		 sendingPort = 587;
		// For a Gmail account--sending mails-- host and port shold be as
		// follows
		       props.put("mail.smtp.host", sendingHost);
               props.put("mail.smtp.password", password);
		       props.put("mail.smtp.auth", true);
               props.put("mail.stmp.user" , "userName");
	        //To use TLS
	        props.put("mail.smtp.auth", "true"); 
	        props.put("mail.smtp.starttls.enable", "true");
	        //To use SSL
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");
		
	        //Creating a session for checking authentication with username and password
		Session session = Session.getDefaultInstance(props, 
			    new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(
			                userName, password);// Specify the Username and the PassWord
			        }
			});
		
		File f=new File(StringConstants.IMAGE_PATH+"\\"+dto.getProductId()+".png");
		Map<Integer, Map<Integer, String>> getMailListWtihSerivceId=dto.getMailListwithServiceId();
		Set<Integer> services=getMailListWtihSerivceId.keySet();
		for(Integer serviceId:services){
		Map<Integer, String> getMails=getMailListWtihSerivceId.get(serviceId);	
		Set<Integer> mailIds=getMails.keySet();
		for(Integer mailId:mailIds){
		Message simpleMessage = new MimeMessage(session);
		// MIME stands for Multipurpose Internet Mail Extensions
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(userName);
			toAddress = new InternetAddress(getMails.get(mailId));
		} 
		catch (AddressException e) {
			e.printStackTrace();
			return 0;
		}
		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(this.subject);
	         simpleMessage.setText(this.text);
			//simpleMessage.setSentDate(new Date());
			Transport transport = session.getTransport("smtps");
			transport.connect(sendingHost, userName, password);
			MimeBodyPart messageBodypart=new MimeBodyPart();
			
			Multipart multipart=new MimeMultipart();
	         String htmlText = "<H1 style='text-align:center'>"+dto.getProductName()+" "+dto.getProductType()+"</H1><table style='border: 1px solid blue' align='center'><tr><th><a href='"+StringConstants.URL_PATH+"viewProduct?productId="+dto.getProductId()+"&mailId="+mailId+"&serviceId="+serviceId+"'><img src=\"cid:image\"></a></th></tr></table>";
	         htmlText+="<br><a href='"+StringConstants.URL_PATH+"viewProduct?productId="+dto.getProductId()+"&mailId="+mailId+"&serviceId="+serviceId+"'>Check here for more details!</a>";
	        // messageBodypart.setContent(htmlBody,"text/html");
	         messageBodypart.setContent(htmlText, "text/html");
	         // add it
	         multipart.addBodyPart(messageBodypart);
			
			System.out.println(f.getName());
			messageBodypart=new MimeBodyPart();
			 DataSource fds = new FileDataSource(f);
	         messageBodypart.setDataHandler(new DataHandler(fds));
	         messageBodypart.setHeader("Content-ID", "<image>");
	         multipart.addBodyPart(messageBodypart);
			 simpleMessage.setContent(multipart);
			 System.out.println(simpleMessage);
			Transport.send(simpleMessage);
			System.out.println("Mail send to "+toAddress);
			//transport.close();
		}
		
		catch (MessagingException e) {
			System.out.println("mail not send");
			e.printStackTrace();
			return 0;
		}
		}
		}
		return 1;

	}
		/*public static void main(String[] args) {
			SendMailUtil amu=new SendMailUtil();
			amu.sendGmail("wdeshmukh7@gmail.com","project mail by");
			System.out.println("mail send");
		}*/
	
}
