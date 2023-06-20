package com.unla.grupo6.controllers;

import java.util.List;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.servicies.IEventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@GetMapping("/lista")
	public String listarEventos(Model model) {

		model.addAttribute("titulo", "Eventos");
		model.addAttribute("lista", eventoService.getAll());

		return ViewRouterHelper.EVENTO_LISTA;
	}
	
	@GetMapping("/lista/verEventoDispositivo")
	public String verEventos(Model model) {
	    // Obtener el dispositivo del evento
		model.addAttribute("lista", eventoService.getAll());
		List<Evento> listaEventos = eventoService.getAll();

	    // Redireccionar a la vista correspondiente según el dispositivo
		for (Evento evento : listaEventos) {
	        switch (evento.getDispositivo().getNombre()) {
	            case "Baño":
	                return ViewRouterHelper.EVENTO_BANIO;
	            case "Luces":
	                return ViewRouterHelper.EVENTO_LUCES;
	            case "Estacionamiento":
	                return ViewRouterHelper.EVENTO_ESTACIONAMIENTO;
	            case "Espacio Verde":
	                return ViewRouterHelper.EVENTO_ESPACIO_VERDE;
	            default:
	                // Manejar otros casos o lanzar una excepción si es necesario
	                break;
	        }
		}

	    // Si no se encuentra el dispositivo, puedes manejarlo de acuerdo a tus necesidades
	    return "error"; // Redireccionar a una página de error u otra vista adecuada
	}
	
}
