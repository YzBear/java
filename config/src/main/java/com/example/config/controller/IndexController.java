package com.example.config.controller;


import com.example.config.bean.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController("/")

public class IndexController {
	@Autowired
	private BlogProperties blogProperties;
	@Autowired
	private ConfigBean configBean;



	@GetMapping("/show")
	public  String show() {
		return "chunchunwudi";
	}

	@GetMapping("/blogProperties")
	String blogProperties() {
		return blogProperties.getName()+"，"+blogProperties.getTitle();
	}
	@GetMapping("/configBean")
	String configBean() {
		return configBean.getName()+"，"+configBean.getTitle()+","+configBean.getWholeTitle();
	}


}
