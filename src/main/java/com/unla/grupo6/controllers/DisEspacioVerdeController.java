package com.unla.grupo6.controllers;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.DisEspacioVerde;
import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.entities.Dispositivo;
import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.implementation.EspacioVerdeService;
import com.unla.grupo6.models.DisEspacioVerdeModel;
import com.unla.grupo6.models.DisEstacionamientoModel;
import com.unla.grupo6.models.DispositivoModel;
import com.unla.grupo6.servicies.IEspacioVerdeService;
import com.unla.grupo6.servicies.IEstacionamientoService;
import com.unla.grupo6.servicies.IEventoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/espacioverde")
public class DisEspacioVerdeController {

	@Autowired
	@Qualifier("espacioVerdeService")
	private IEspacioVerdeService espacioVerdeService;
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@GetMapping("/index") // me lo muestra raro
	public String indexTest() {
		return ViewRouterHelper.ESPACIOVERDE_INDEX;
	}


	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.ESPACIOVERDE_ROUTE_INDEX);
	}
	
	@GetMapping("/crear")
	public String crearVerdes(Model model) {
		DisEspacioVerde disEspacioVerde = new DisEspacioVerde();
		model.addAttribute("titulo", "Formulario: Nuevo Sensor");
		model.addAttribute("espacioverde", disEspacioVerde);
		model.addAttribute("lista", espacioVerdeService.getAll());

		return ViewRouterHelper.ESPACIOVERDE_CREAR;
	}

	@GetMapping("/listaverde")
	public String listaVerdes(Model model) {
		List<DisEspacioVerde> verdeLista = espacioVerdeService.getAll();
		List<DisEspacioVerde> lista = new ArrayList<DisEspacioVerde>();

		for (DisEspacioVerde e : verdeLista) {
			if (e.isBaja() == false) {
				lista.add(e);
			}
		}

		model.addAttribute("titulo", "Lista de sensores espacio verde");
		model.addAttribute("lista", lista);
		return ViewRouterHelper.ESPACIOVERDE_LISTA;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public String guardarVerdes(@Valid @ModelAttribute DisEspacioVerde disEspacioVerde, BindingResult result,
			Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
			model.addAttribute("espacioverde", disEspacioVerde);
			model.addAttribute("lista", espacioVerdeService.getAll());
			System.out.println("Existieron errores en el formulario");
			return ViewRouterHelper.ESPACIOVERDE_CREAR;
		}

		if (disEspacioVerde.getHumedad() < 30) {
			disEspacioVerde.setBajaHumedad(true);
			disEspacioVerde.setRegando("Activado");
		} else {
			disEspacioVerde.setBajaHumedad(false);
			disEspacioVerde.setRegando("Desactivado");
		}
		if (disEspacioVerde.isEnFuncionamiento() == false) {	
			disEspacioVerde.setRegando("No se puede activar regado");
		}

		espacioVerdeService.saveVerde(disEspacioVerde);
		System.out.println("guardado con exito!");
		attribute.addFlashAttribute("success", "Dispositivo espacio verde ");
		
		Evento nuevoEvento = new Evento(disEspacioVerde, LocalDateTime.now(), disEspacioVerde.getNombre());
		eventoService.saveEvento(nuevoEvento);
		
		return ViewRouterHelper.ESPACIOVERDE_REDIRECT_LISTA;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("listaverde/edit/{idDispositivo}")
	public String editar(@PathVariable("idDispositivo") Long idDispositivo, Model model, RedirectAttributes attribute) {

		DisEspacioVerde disespacioverde = espacioVerdeService.buscarVerde(idDispositivo);
		model.addAttribute("titulo", "Formulario: Editar sensor espacio verde");
		model.addAttribute("espacioverde", disespacioverde);
		model.addAttribute("listaverde", espacioVerdeService.getAll());
		
		Evento nuevoEvento = new Evento(disespacioverde, LocalDateTime.now(), disespacioverde.getNombre());
		eventoService.saveEvento(nuevoEvento);

		return ViewRouterHelper.ESPACIOVERDE_CREAR;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@GetMapping("listaverde/delete/{idDispositivo}")
	public String eliminar(@PathVariable("idDispositivo") Long idDispositivo, RedirectAttributes attribute) {
		DisEspacioVerde disespacioverde = espacioVerdeService.buscarVerde(idDispositivo);

		disespacioverde.setBaja(true);
		espacioVerdeService.saveVerde(disespacioverde);
		System.out.println("Registro eliminado con exito");
		attribute.addFlashAttribute("warning", "Dispositivo eliminado con exito");
		return ViewRouterHelper.ESPACIOVERDE_REDIRECT_LISTA;
	}
	
	
	@PreAuthorize("hasRole('ROLE_AUDITOR')")
	@GetMapping("listaverde/versensor/{idDispositivo}")
	public String verSensor(@PathVariable("idDispositivo") Long idDispositivo, Model model,
			RedirectAttributes attribute) {

		DisEspacioVerde disespacioverde = espacioVerdeService.buscarVerde(idDispositivo);

		if (disespacioverde.isEnFuncionamiento() == false) {
			attribute.addFlashAttribute("error",
					"ATENCION: El sensor seleccionado no se puede ver porque esta en mantenimiento y/o no funciona");
			return ViewRouterHelper.ESPACIOVERDE_REDIRECT_LISTA;
		}

		model.addAttribute("titulo", "Ver Sensor");
		model.addAttribute("espacioverde", disespacioverde);
		return ViewRouterHelper.ESPACIOVERDE_VER_SENSOR;
	}

}
