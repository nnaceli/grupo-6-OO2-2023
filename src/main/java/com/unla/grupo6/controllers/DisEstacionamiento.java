package com.unla.grupo6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estacionamiento")
public class DisEstacionamiento {
	
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
	
}
