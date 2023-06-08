package com.unla.grupo6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/estacionamiento")
public class DisEstacionamientoController {
	
	@GetMapping("index")
	public String index() {
		return "DisEstacionamiento/index";
	}
	
	@GetMapping("estacionamientoDisponibles")
	public String estacionamientoDisponibles() {
		return "DisEstacionamiento/estacionamientosGeneral";
	}
	
	@GetMapping("agregar")
	public String agregar() {
		return "DisEstacionamiento/agregarDispositivo";
	}
	
	@GetMapping("modificar")
	public String modificar() {
		return "DisEstacionamiento/modificarDispositivo";
	}
	
	@GetMapping("eliminar")
	public String eliminar() {
		return "DisEstacionamiento/eliminarDispositivo";
	}
	
	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView("DisEstacionamiento/index");
	}
}
