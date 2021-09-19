package com.vn.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vn.demo.entity.MailModel;

@Service
public class MailerService {
	@Autowired
	JavaMailSender mailSender;
	List<MimeMessage> queue = new ArrayList<>();
    public void push(String to, String subject, String body) {
		MailModel mail = new MailModel(to, subject, body);
		this.push(mail);
	}
    public void push(MailModel mail) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
	    	MimeMessageHelper heper;
			heper = new MimeMessageHelper(message, true, "UTF-8");
			heper.setFrom(mail.getFrom());
	    	heper.setTo(mail.getTo());
	    	heper.setSubject(mail.getSubject());
	    	heper.setText(mail.getBody(), true);
	    	heper.setReplyTo(mail.getFrom());
	    	for(String email: mail.getCc()) {
	    		heper.addCc(email);
	    	}
	    	for(String email: mail.getBcc()) {
	    		heper.addBcc(email);
	    	}
	    	for (File file: mail.getFiles()) {
	    		heper.addAttachment(file.getName(), file);
	    	}
	    	mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("loi day nay: "+e);
			e.printStackTrace();
		}
    	
	}
//    @Scheduled(cron = "0***FIR")
//    public void run() {
//    	int succsess=0,error=0;
//    	while (!queue.isEmpty()) {
//			MimeMessage message = queue.remove(0);
//			try {
//				mailSender.send(message);
//				succsess++;
//			} catch (Exception e) {
//				error++;
//			}
//		}
//    	System.out.printf("send: %d, error: %d\r\n",succsess,error);
//    }
}
