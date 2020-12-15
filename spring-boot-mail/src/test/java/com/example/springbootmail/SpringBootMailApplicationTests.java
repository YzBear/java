package com.example.springbootmail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.TemplateEngine;

import javax.mail.internet.MimeMessage;
import java.io.File;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableCaching
class SpringBootMailApplicationTests {

	@Test
	void contextLoads() {
		File file = new File("src/main/resources/static/file/项目文档.docx");
		FileSystemResource file2 = new FileSystemResource(file);
		System.out.println(file.getName());
		System.out.println(file2.getFilename());
	}

	@Autowired
	private JavaMailSender jms;

	@Value("${spring.mail.username}")
	private String from;

	@Autowired
	private TemplateEngine templateEngine;
	@Test
	void  test(){
		MimeMessage message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo("iyanzixiong@163.com"); // 接收地址
			helper.setSubject("一封带附件的邮件"); // 标题
			helper.setText("详情参见附件内容！"); // 内容
			// 传入附件
			FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/file/项目文档.docx"));
			helper.addAttachment("项目文档.docx", file);
			jms.send(message);
			System.out.println("发送成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("发送失败！");
		}
	}

}
