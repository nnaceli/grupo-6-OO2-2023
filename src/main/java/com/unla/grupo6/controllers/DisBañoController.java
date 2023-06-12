package com.unla.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.unla.grupo6.servicies.IBañoService;
import com.unla.grupo6.helpers.ViewRouterHelper;


@Controller
@RequestMapping("/baño")
public class DisBañoController {
	
	@Autowired
	@Qualifier("bañoService")
	private IBañoService bañoService;
	
	@GetMapping("/index")
	public String index() {
		return ViewRouterHelper.BAÑO_INDEX;
	}
	
}
