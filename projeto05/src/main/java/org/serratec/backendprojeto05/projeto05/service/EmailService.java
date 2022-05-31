package org.serratec.backendprojeto05.projeto05.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backendprojeto05.projeto05.DTO.CartaoDTO;
import org.serratec.backendprojeto05.projeto05.exceptions.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String senha;
	
	
	private final String emailRemetente = "";
	
	public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();
		
		enviarEmail.setHost("smtp.gmail.com");
		enviarEmail.setPort(465);
		enviarEmail.setUsername(username);
		enviarEmail.setPassword(senha);
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);
		
		return enviarEmail;
	}
	
	public void sendMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailRemetente);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	public void emailTeste(CartaoDTO cartaoDTO) throws MessagingException, EmailException {
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		try {
			helper.setFrom("");
			helper.setTo("");
			
			helper.setSubject("TESTE DA ISABEL");
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html> <h1>Parabéns, </h1> " + cartaoDTO.getNomeTitular() 
			+ "< /br><p>Seu cartao foi criado com número: </p>" + cartaoDTO.getNumeroCartao()
			+ "</html>");
			
			helper.setText(sBuilder.toString(), true);
			
			emailSender.send(message);
			
		} catch (Exception e) {
			throw new EmailException("Houve um erro ao enviar esse email" + e.getMessage());
			
			}
	}
}


		
	

