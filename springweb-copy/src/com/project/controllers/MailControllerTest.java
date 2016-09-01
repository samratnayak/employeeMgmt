package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailControllerTest {
	@Autowired
	MailSender mailSender;

	@RequestMapping(value="/sendTestMail")
	public String sendMail(){
		SimpleMailMessage email= new SimpleMailMessage();
		email.setFrom("thisissamrat.nayak@gmail.com");
		email.setSubject("My subject");
		email.setText("This is a test email from my java application, i have hard coded the values :)");
		email.setTo("debasishj21@gmail.com");
		mailSender.send(email);
		return "MessageSent";
	}
}
