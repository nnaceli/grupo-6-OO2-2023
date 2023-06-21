package com.unla.grupo6.controllers;

import java.time.LocalDateTime;


import java.util.ArrayList;

import java.util.List;
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
import java.util.Random;
import com.unla.grupo6.servicies.IBañoService;
import com.unla.grupo6.servicies.IEventoService;

import jakarta.validation.Valid;
import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.helpers.ViewRouterHelper;


@Controller
@RequestMapping("/banio")
public class DisBañoController {
	
	@Autowired
	@Qualifier("bañoService")
	private IBañoService bañoService;
	
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	
	
	@GetMapping("/index")
	public String index() {
		return ViewRouterHelper.BANIO_INDEX;
	}
	
	@GetMapping("/lista")
	public String listarBaños(Model model) {
		List<DisBaño> baniosLista = bañoService.getAll();
		List<DisBaño> lista = new ArrayList<DisBaño>();
		
		for(DisBaño b: baniosLista) {
			if (b.isBaja() == false){
				lista.add(b);
			}
		}
		
		model.addAttribute("titulo", "BAÑOS");
		model.addAttribute("lista", lista);
		return ViewRouterHelper.BANIO_LISTA;
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		DisBaño disBaño = new DisBaño();
		model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
		model.addAttribute("banio", disBaño);
		model.addAttribute("lista", bañoService.getAll());
		
		return ViewRouterHelper.BANIO_CREAR;
	}
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute DisBaño disBaño, BindingResult result, Model model,
			RedirectAttributes attribute ) {
		
		
		
	    
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
			model.addAttribute("banio", disBaño);
			model.addAttribute("lista", bañoService.getAll());
			
			System.out.println("Existieron errores en el formulario");
			return ViewRouterHelper.BANIO_CREAR;
		}
		
		if (disBaño.isHigienizandose()) {
			disBaño.setHabilitado(false);
		} else {
			disBaño.setHabilitado(true);
		}
		
		disBaño.setNombre("Dispositivo Baño");
		
		bañoService.save(disBaño);
		System.out.println("Dispositivo Baño guardado con exito!");
		attribute.addFlashAttribute("success", "Dispositivo Baño guardado con exito ");
		
		Evento nuevoEvento = new Evento(disBaño,LocalDateTime.now());
		eventoService.saveEvento(nuevoEvento);
		
		return ViewRouterHelper.BANIO_REDIRECT_LISTA;
	}
	
	@GetMapping("lista/edit/{idDispositivo}")
	public String editar(@PathVariable("idDispositivo") Long idDispositivo, Model model, RedirectAttributes attribute ) {
		
		DisBaño disBaño= bañoService.buscar(idDispositivo);
		model.addAttribute("titulo", "Formulario: Editar Camara Baño");
		model.addAttribute("banio", disBaño);
		model.addAttribute("lista", bañoService.getAll());
		
		Evento nuevoEvento = new Evento(disBaño,LocalDateTime.now());
		eventoService.saveEvento(nuevoEvento);
		
		return ViewRouterHelper.BANIO_CREAR;
	}
	
	@GetMapping("lista/delete/{idDispositivo}")
	public String eliminar(@PathVariable("idDispositivo") Long idDispositivo, RedirectAttributes attribute) {
		DisBaño disBaño= bañoService.buscar(idDispositivo); 
		
		disBaño.setBaja(true);
		bañoService.save(disBaño);
		System.out.println("Registro eliminado con exito");
		attribute.addFlashAttribute("warning", "Dispositivo eliminado con exito");
		return ViewRouterHelper.BANIO_REDIRECT_LISTA;
	}
	
	@GetMapping("lista/verCamara/{idDispositivo}")
	public String verCamara(@PathVariable("idDispositivo") Long idDispositivo, Model model, RedirectAttributes attribute ) {
		
		DisBaño disBaño= bañoService.buscar(idDispositivo);
		
		
		
		
		 Random random = new Random();
		 boolean randomValue = random.nextBoolean();
		 disBaño.setHigienizandose(randomValue);
		 if(randomValue) {
			 disBaño.setHabilitado(false);
			 bañoService.save(disBaño);
		 }else {
			 disBaño.setHabilitado(true);
			 bañoService.save(disBaño);
		 }
		
		if(disBaño.isEnFuncionamiento()== false) {
			 attribute.addFlashAttribute("error","ATENCION: La camara seleccionada no se puede ver porque no funciona");
			 return ViewRouterHelper.BANIO_REDIRECT_LISTA;
		}
		
		model.addAttribute("titulo", "Ver Camara");
		model.addAttribute("banio", disBaño);
		
		Evento nuevoEvento = new Evento(disBaño,LocalDateTime.now());
		eventoService.saveEvento(nuevoEvento);
		
		return ViewRouterHelper.BANIO_VER_CAMARA;
	}
	
	
	

	
}
