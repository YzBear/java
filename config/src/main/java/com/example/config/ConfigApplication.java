package com.example.config;

import com.example.config.bean.ConfigBean;
import com.example.config.bean.TestConfigBean;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@EnableConfigurationProperties({ConfigBean.class,TestConfigBean.class})
/*@ImportResource({"classpath:XXX-application.xml"})*/
@ComponentScan("com.example.config.bean")
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(ConfigApplication.class, args);*/
		SpringApplication app = new SpringApplication(ConfigApplication.class);
		app.setAddCommandLineProperties(false);
		app.run(args);
	}

}
