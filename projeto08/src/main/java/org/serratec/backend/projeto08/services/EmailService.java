package org.serratec.backend.projeto08.services;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backend.projeto08.dto.ServicoDTO;
import org.serratec.backend.projeto08.exceptions.EmailException;
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

	@Autowired
	ClienteService clienteService;

	@Value("${spring.mail.username}")
	private String username;

	@Value("${spring.mail.password}")
	private String senha;

	private final String emailRemetente = "isabeel.s@hotmail.com";

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

	public void emailTeste(ServicoDTO servicoDTO) throws MessagingException, EmailException {

		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setFrom("serratecRenan@gmail.com");
			helper.setTo("isabeel.s@hotmail.com");
			helper.setSubject("COMPROVANTE DE SERVIÇO - BORRACHARIA DA ISABEL");

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<!DOCTYPE html>" + "<head>"
					+ "</head>" + "<body>" + "<div class='card'>" + "<div class='card-header'>"
					+ "<h2>Borracharia da Isabel</h2>" + "<h3>Comprovante do Serviço</h3>" + "</div>"
					+ "<div class='card-body'>" + "<ul>" + "<li><b>Tipo do Serviço: </b>" + servicoDTO.getTipoServico()
					+ "</li>" + "<li><b>Valor: </b>" + servicoDTO.getValorServico() + "</li>" + "<li><b>Data: </b>"
					+ servicoDTO.getDataServico() + "</li>"

					+ "</ul>" + "</div>" + "<div class='card-footer'>"
					+ "<ahref='#' class='btn'>Baixar a nota fiscal</a>" + "</div>" + "</div>" + "</body>" + "</html>");

			helper.setText(sBuilder.toString(), true);

			emailSender.send(message);

		} catch (Exception e) {
			throw new EmailException("Houve um erro ao enviar esse email" + e.getMessage());

		}
	}
}
