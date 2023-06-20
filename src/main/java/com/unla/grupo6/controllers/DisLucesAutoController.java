package com.unla.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo6.entities.DisLucesAuto;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.servicies.ILucesAutoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/lucesautomaticas")
public class DisLucesAutoController {

//	@GetMapping("/helloworld")
//	public String helloWorld() {
//		return ViewRouterHelper.LUCES_HOLA;
//	}

	@Autowired
	private ILucesAutoService lucesService;

	@GetMapping("/index")
	public String index() {
		return ViewRouterHelper.LUCES_INDEX;
	}

	@GetMapping("/agregarLuces")
	public String agregar(Model model) {
		DisLucesAuto disLucesAuto = new DisLucesAuto();
		model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
		model.addAttribute("disLucesAuto", disLucesAuto);
		model.addAttribute("lista", lucesService.getAll());
		return ViewRouterHelper.LUCES_AGREGAR;
	}

	@GetMapping("/listaLucesAuto")
	public String listarBaños(Model model) {
		model.addAttribute("titulo", "Lista de Luces Automaticas");
		model.addAttribute("lista", lucesService.getAll());
		return ViewRouterHelper.LUCES_AGREGADAS;
	}

	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute DisLucesAuto disLucesAuto, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
			model.addAttribute("lucesautomaticas", disLucesAuto);
			model.addAttribute("lista", lucesService.getAll());
			System.out.println("Existieron errores en el formulario");
			return ViewRouterHelper.LUCES_AGREGAR;
		}

		lucesService.save(disLucesAuto);
		attribute.addFlashAttribute("correcta", "Dispositivo Luces Automaticas guardado de forma ");
		return ViewRouterHelper.LUCES_REDIRECT_AGREGADAS;
	}

	@GetMapping("/listaLucesAuto/modificarLuces/{idDispositivo}")
	public String modificar(@PathVariable("idDispositivo") Long idDispositivo, Model model) {
		DisLucesAuto disLucesAuto = lucesService.buscar(idDispositivo);
		model.addAttribute("titulo", "Formulario: Modificar Dispositivo");
		model.addAttribute("disLucesAuto", disLucesAuto);
		model.addAttribute("lista", lucesService.getAll());
		
		return ViewRouterHelper.LUCES_AGREGAR;
	}

	@GetMapping("/eliminarLuces")
	public String eliminar() {
		return ViewRouterHelper.LUCES_ELIMINAR;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.LUCES_INDEX);
	}

}