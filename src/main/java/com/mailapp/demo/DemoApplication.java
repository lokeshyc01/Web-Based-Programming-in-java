package com.mailapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private EmailService emailService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	private void sendEmail()
	{
		emailService.sendEmail("anilbemech2020@gmail.com", "java mail sending service testing",
				"<!DOCTYPE html>\n"
				+ "	<html>\n"
				+ "	\n"
				+ "	<head>\n"
				+ "		<meta charset=\"UTF-8\">\n"
				+ "		<title>OTP Verification Email</title>\n"
				+ "		<style>\n"
				+ "			body {\n"
				+ "				background-color: #ffffff;\n"
				+ "				font-family: Arial, sans-serif;\n"
				+ "				font-size: 16px;\n"
				+ "				line-height: 1.4;\n"
				+ "				color: #333333;\n"
				+ "				margin: 0;\n"
				+ "				padding: 0;\n"
				+ "			}\n"
				+ "	\n"
				+ "			.container {\n"
				+ "				max-width: 600px;\n"
				+ "				margin: 0 auto;\n"
				+ "				padding: 20px;\n"
				+ "				text-align: center;\n"
				+ "			}\n"
				+ "	\n"
				+ "			.logo {\n"
				+ "				max-width: 200px;\n"
				+ "				margin-bottom: 20px;\n"
				+ "			}\n"
				+ "	\n"
				+ "			.message {\n"
				+ "				font-size: 18px;\n"
				+ "				font-weight: bold;\n"
				+ "				margin-bottom: 20px;\n"
				+ "			}\n"
				+ "	\n"
				+ "			.body {\n"
				+ "				font-size: 16px;\n"
				+ "				margin-bottom: 20px;\n"
				+ "			}\n"
				+ "	\n"
				+ "			.cta {\n"
				+ "				display: inline-block;\n"
				+ "				padding: 10px 20px;\n"
				+ "				background-color: #FFD60A;\n"
				+ "				color: #000000;\n"
				+ "				text-decoration: none;\n"
				+ "				border-radius: 5px;\n"
				+ "				font-size: 16px;\n"
				+ "				font-weight: bold;\n"
				+ "				margin-top: 20px;\n"
				+ "			}\n"
				+ "	\n"
				+ "			.support {\n"
				+ "				font-size: 14px;\n"
				+ "				color: #999999;\n"
				+ "				margin-top: 20px;\n"
				+ "			}\n"
				+ "	\n"
				+ "			.highlight {\n"
				+ "				font-weight: bold;\n"
				+ "			}\n"
				+ "		</style>\n"
				+ "	\n"
				+ "	</head>\n"
				+ "	\n"
				+ "	<body>\n"
				+ "		<div class=\"container\">\n"
				+ "			\n"
				+ "			<div class=\"message\">OTP Verification Email</div>\n"
				+ "			<div class=\"body\">\n"
				+ "				<p>Dear User,</p>\n"
				+ "				<p>Thank you for registering with studyBot. To complete your registration, please use the following OTP\n"
				+ "					(One-Time Password) to verify your account:</p>\n"
				+ "				\n"
				+ "				<p>This OTP is valid for 5 minutes. If you did not request this verification, please disregard this email.\n"
				+ "				Once your account is verified, you will have access to our platform and its features.</p>\n"
				+ "			</div>\n"
				+ "			\n"
				+ "		</div>\n"
				+ "	</body>\n"
				+ "	\n"
				+ "	</html>;");
	}
}
