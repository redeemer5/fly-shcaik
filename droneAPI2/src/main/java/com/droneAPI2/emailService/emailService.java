package com.droneAPI2.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.droneAPI2.models.requestModel;

@Service
public class emailService {
	
private JavaMailSender javaMailSender;
	
	@Autowired 
	public emailService(JavaMailSender javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}

		
	public void sendEmail(requestModel req) throws MailException
	{
		// send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(req.getEmail());
		mail.setFrom("w12rline6@gmail.com");
		mail.setSubject("Fly schaik");
		mail.setText("Thank you for your request. Please view your book request details below:" + "\n" + "\n" +"library name: " +req.getLibrary() + ", order number: " +req.getOrdernumber() +"\n" +"book ordered: " + req.getItem() +"\n" +"Expected time of arrival will be within an hour! "  +"\n" +"\n" +"Happy reading!" +"\n"+ "we drop knowledge! ");
	
		
		
		javaMailSender.send(mail);
	}

}
