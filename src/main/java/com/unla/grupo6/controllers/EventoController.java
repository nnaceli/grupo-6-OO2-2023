package com.unla.grupo6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
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
	public String listarEventos(Model model, @Param("palabraClave") String palabraClave) {
		List<Evento> lista = eventoService.getAll(palabraClave);

		model.addAttribute("titulo", "Eventos");
		model.addAttribute("lista", lista);
		model.addAttribute("palabraClave", palabraClave);

		return ViewRouterHelper.EVENTO_LISTA;
	}

}
