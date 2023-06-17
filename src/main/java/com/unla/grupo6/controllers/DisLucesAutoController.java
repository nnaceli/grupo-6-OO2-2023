package com.unla.grupo6.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo6.entities.DisLucesAuto;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.models.DisLucesAutoModel;
import com.unla.grupo6.servicies.ILucesAutoService;

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
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouterHelper.LUCES_INDEX);
		mV.addObject("Luces Automaticas", lucesService.getAll());
		mV.addObject("Luz Automatica", new DisLucesAuto());
		return mV;
	}

//	@PostMapping("/index")
//	public RedirectView nombre(@ModelAttribute("Luz Automatica") DisLucesAutoModel disLucesAutoModel) {
//		lucesService.insertOrUpdate(disLucesAutoModel);
//		return new RedirectView(ViewRouterHelper.LUCES_ALGO);
//	}

	@GetMapping("/estadoDisLucesAuto")
	public String estadoDisLucesAuto() {
		return "DisLucesAuto/estadoDisLucesAuto";
	}

	@GetMapping("/agregarLuces")
	public String agregarLuces(Model model) {
		model.addAttribute("agregar", new DisLucesAuto());
		return ViewRouterHelper.LUCES_AGREGAR;
	}

	@PostMapping("/lucesAgregada")
	public ModelAndView lucesAgregado(@Valid @ModelAttribute("agregar") DisLucesAutoModel agregarLucesAuto,
			BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mV.setViewName(ViewRouterHelper.LUCES_AGREGAR);
		} else {
			mV.setViewName(ViewRouterHelper.LUCES_AGREGADO);
			mV.addObject("agregar", agregarLucesAuto);
		}
		return mV;
	}

	@GetMapping("/modificarLuces")
	public String modificar() {
		return ViewRouterHelper.LUCES_MODIFICAR;
	}

	@GetMapping("/eliminarLuces")
	public String eliminar() {
		return ViewRouterHelper.LUCES_ELIMINAR;
	}

	@GetMapping("/verificarLuz")
	public String verificarLuz() {
		return ViewRouterHelper.LUCES_VERIFICAR_LUZ;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.LUCES_INDEX);
	}

}