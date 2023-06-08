package com.unla.grupo6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.unla.grupo6.helpers.ViewRouterHelper;


@Controller
@RequestMapping("/estacionamiento")
public class DisEstacionamientoController {
	
	@GetMapping("/index")
	public String index() {
		return ViewRouterHelper.ESTACIONAMIENTO_INDEX;
	}
	 

	@GetMapping("/estacionamientoDisponibles")
	public String estacionamientoDisponibles() {
		return "DisEstacionamiento/estacionamientosGeneral";
	}

	@GetMapping("/plazasDisponibles")
	public String plazasDisponibles() {
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_DISPONIBLES;

	}
	
	@GetMapping("/agregar")
	public String agregar() {
		return ViewRouterHelper.ESTACIONAMIENTO_AGREGAR;
	}
	
	@GetMapping("/agregar/{sector}")
	public ModelAndView agregarDisEstacionamiento(@PathVariable("sector") String sector) {

		ModelAndView mV = new ModelAndView(ViewRouterHelper.ESTACIONAMIENTO_AGREGAR);

		mV.addObject("sector", sector);
		return mV;
	}
	
	@GetMapping("/modificar")
	public String modificar() {
		return ViewRouterHelper.ESTACIONAMIENTO_MODIFICAR;
	}
	
	@GetMapping("/eliminar")
	public String eliminar() {
		return ViewRouterHelper.ESTACIONAMIENTO_ELIMINAR;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.ESTACIONAMIENTO_ROUTE_INDEX);
	}



}
