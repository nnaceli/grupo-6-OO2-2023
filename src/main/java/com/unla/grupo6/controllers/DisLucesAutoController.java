package com.unla.grupo6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lucesautomaticas")
public class DisLucesAutoController {
	
	@GetMapping("helloWorld")
	public String helloWorld() {
		return "DisLucesAuto/helloWorld";
	}
	
	@GetMapping("index")
	public String index() {
		return "DisLucesAuto/index";
	}
	
	@GetMapping("estadoDisLucesAuto")
	public String estadoDisLucesAuto() {
		return "DisLucesAuto/estadoDisLucesAuto";
	}
}