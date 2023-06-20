package com.unla.grupo6.controllers;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.grupo6.entities.DisBaño;
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
		List<Evento> listaEventos = eventoService.getAll();
		
		model.addAttribute("titulo", "Eventos");
		model.addAttribute("lista", eventoService.getAll());
		
		 for (Evento evento : listaEventos) {
	            switch (evento.getDispositivo().getNombre()) {
	                case "Dispositivo Baño":
	                    return ViewRouterHelper.EVENTO_LISTA_BANIO;
	                case "Luces Automaticas":
	                    return ViewRouterHelper.LUCES_REDIRECT_AGREGADAS;
	                default:
	                    // Manejar otros casos o lanzar una excepción si es necesario
	                    break;
	            }
	        }
		
		return null;
	}
	
	

}
