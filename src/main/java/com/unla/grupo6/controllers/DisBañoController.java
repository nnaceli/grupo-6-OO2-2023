package com.unla.grupo6.controllers;

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

import com.unla.grupo6.servicies.IBañoService;

import jakarta.validation.Valid;

import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.helpers.ViewRouterHelper;


@Controller
@RequestMapping("/banio")
public class DisBañoController {
	
	@Autowired
	@Qualifier("bañoService")
	private IBañoService bañoService;
	
	@GetMapping("/index")
	public String index() {
		return ViewRouterHelper.BANIO_INDEX;
	}
	
	@GetMapping("/lista")
	public String listarBaños(Model model) {
		model.addAttribute("titulo", "Lista de Baños");
		model.addAttribute("lista", bañoService.getAll());
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
		
		bañoService.save(disBaño);
		System.out.println("Dispositivo Baño guardado con exito!");
		attribute.addFlashAttribute("success", "Dispositivo Baño guardado con ");
		return ViewRouterHelper.BANIO_REDIRECT_LISTA;
	}
	
	@GetMapping("lista/edit/{idDispositivo}")
	public String editar(@PathVariable("idDispositivo") Long idDispositivo, Model model, RedirectAttributes attribute ) {
		
		DisBaño disBaño= bañoService.buscar(idDispositivo);
		model.addAttribute("titulo", "Formulario: Editar Camara Baño");
		model.addAttribute("banio", disBaño);
		model.addAttribute("lista", bañoService.getAll());
		
		return ViewRouterHelper.BANIO_CREAR;
	}
	
	@GetMapping("lista/delete/{idDispositivo}")
	public String eliminar(@PathVariable("idDispositivo") Long idDispositivo, RedirectAttributes attribute) {
		bañoService.eliminar(idDispositivo);
		System.out.println("Registro eliminado con exito");
		attribute.addFlashAttribute("warning", "Dispositivo eliminado con exito");
		return ViewRouterHelper.BANIO_REDIRECT_LISTA;
	}

	
}
