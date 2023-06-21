package com.unla.grupo6.controllers;

import java.util.List;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.Dispositivo;
import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.servicies.IEventoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@GetMapping("/lista")
	public String listarEventos(Model model) {

		List<Evento> lista = eventoService.getAll();
	
		model.addAttribute("titulo", "Eventos");
		model.addAttribute("lista", lista);
		
		return ViewRouterHelper.EVENTO_LISTA;
	}
	
	@PostMapping("/save")
	public Evento guardar(@Valid @ModelAttribute Dispositivo dis, BindingResult result, Model model,
			RedirectAttributes attribute ) {
		
		
		Evento nuevoEvento = new Evento(dis,LocalDateTime.now());
		eventoService.saveEvento(nuevoEvento);
		return nuevoEvento;
	}
	
	
	@GetMapping("lista/verEvento/{id}")
	public String verEvento(@PathVariable("id") Long id, Model model, RedirectAttributes attribute ) {
		
		Evento evento= eventoService.buscar(id);

		
		model.addAttribute("titulo", "Ver Camara");
		model.addAttribute("evento", evento);
		

		
		return ViewRouterHelper.EVENTO_BANIO;
	}
	

}
