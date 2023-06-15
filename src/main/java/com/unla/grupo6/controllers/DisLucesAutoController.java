package com.unla.grupo6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.models.DisLucesAutoModel;

@Controller
@RequestMapping("/lucesautomaticas")
public class DisLucesAutoController {

//	@GetMapping("helloWorld")
//	public String helloWorld() {
//		return "DisLucesAuto/helloWorld";
//	}

	@GetMapping("/index")
	public String index() {
		return ViewRouterHelper.LUCES_INDEX;
	}

	@GetMapping("/estadoDisLucesAuto")
	public String estadoDisLucesAuto() {
		return "DisLucesAuto/estadoDisLucesAuto";
	}

//	@GetMapping("/agregarLuces")
//	public String agregarLuces(Model model){
//		model.addAttribute("agregar", new DisLucesAutoModel());
//		return ViewRouterHelper.LUCES_AGREGAR;
//	}
	
	@GetMapping("/modificar")
	public String modificar() {
		return ViewRouterHelper.LUCES_MODIFICAR;
	}
	
	@GetMapping("/eliminar")
	public String eliminar() {
		return ViewRouterHelper.LUCES_ELIMINAR;
	}
	
	@GetMapping("/cambiarEstado")
	public String cambiarEstado() {
		return ViewRouterHelper.LUCES_CAMBIAR_ESTADO;
	}
	
	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.LUCES_INDEX);
	}

//	public final static String LUCES_AGREGAR = "DisLucesAuto/agregarLuces";
//	public final static String LUCES_MODIFICAR= "DisLucesAuto/modificarLuces";
//	public final static String LUCES_ELIMINAR= "DisLucesAuto/eliminarLuces";
//	public final static String LUCES_CAMBIAR_ESTADO= "DisLucesAuto/cambiarEstado";
}