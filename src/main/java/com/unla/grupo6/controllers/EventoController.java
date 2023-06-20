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

<<<<<<< HEAD
//	@GetMapping("/lista")
//	public String listarEventos(Model model) {
//
//		List<Evento> listaEventos = eventoService.getAll();
//
//		model.addAttribute("titulo", "Eventos");
//		model.addAttribute("lista", eventoService.getAll());
//
//		return ViewRouterHelper.;
//	}
=======
	@GetMapping("/lista")
	public String listarEventos(Model model) {

		model.addAttribute("titulo", "Eventos");
		model.addAttribute("lista", eventoService.getAll());

		return ViewRouterHelper.EVENTO_LISTA;
	}
>>>>>>> 1fd163cd8d7b2228f94770c186ed052e6f46e674

}
