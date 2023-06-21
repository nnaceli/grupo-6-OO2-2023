package com.unla.grupo6.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.grupo6.helpers.ViewRouterHelper;



@Controller
public class UserController {
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error", required=false) String error, @RequestParam(name="logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		return ViewRouterHelper.USER_LOGIN;
	}
	
	@GetMapping("/logout")
	public String logout (Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            // Limpiar la sesión y invalidar la autenticación
            SecurityContextHolder.clearContext();

            // Aquí puedes realizar otras tareas de limpieza o acciones personalizadas según tus necesidades
        }
		
		return ViewRouterHelper.USER_LOGOUT;
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return ViewRouterHelper.HOME_INDEX;
	}
	

}
