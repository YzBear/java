package com.example.springbootactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class SpringBootActuatorApplication {

	public static void main(String[] args) {
		// 建议仅在开发或者排除时开启此配置
		new SpringApplicationBuilder(SpringBootActuatorApplication.class)
				.applicationStartup(new BufferingApplicationStartup(20480))
				.run(args);
	}

}
