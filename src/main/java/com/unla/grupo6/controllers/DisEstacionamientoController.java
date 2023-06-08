package com.unla.grupo6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/estacionamiento")
public class DisEstacionamientoController {
	
	@GetMapping("/index")
	public String index() {
		return "DisEstacionamiento/index";
	}
	
	@GetMapping("/estacionamientoDisponibles")
	public String estacionamientoDisponibles() {
		return "DisEstacionamiento/estacionamientosGeneral";
	}
	
	@GetMapping("/agregar")
	public String agregar() {
		return "DisEstacionamiento/agregarDispositivo";
	}
	
	@GetMapping("/agregar/{sector}")
	public ModelAndView agregarDisEstacionamiento(@PathVariable("sector") String sector) {
		ModelAndView mV = new ModelAndView("DisEstacionamiento/agregarDispositivo");
		mV.addObject("sector", sector);
		return mV;
	}
	
	@GetMapping("/modificar")
	public String modificar() {
		return "DisEstacionamiento/modificarDispositivo";
	}
	
	@GetMapping("/eliminar")
	public String eliminar() {
		return "DisEstacionamiento/eliminarDispositivo";
	}
	
	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView("DisEstacionamiento/index");
	}
}
