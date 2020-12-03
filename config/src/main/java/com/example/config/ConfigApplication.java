package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@EnableConfigurationProperties({ConfigBean.class,TestConfigBean.class})
*/

/*

@ComponentScan("com.example.config.bean")*/
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(ConfigApplication.class, args);*/
		SpringApplication app = new SpringApplication(ConfigApplication.class);
		app.setAddCommandLineProperties(false);
		app.run(args);
	}

}
