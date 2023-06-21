package com.unla.grupo6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo6.helpers.ViewRouterHelper;

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping("/index")
	public ModelAndView index(@ModelAttribute("loginSuccess") Boolean loginSuccess) {
		ModelAndView modelAndView = new ModelAndView(ViewRouterHelper.HOME_INDEX);

		return modelAndView;
	}
}
