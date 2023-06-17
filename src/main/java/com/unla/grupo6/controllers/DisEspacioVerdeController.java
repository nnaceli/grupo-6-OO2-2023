package com.unla.grupo6.controllers;

import javax.validation.Valid;

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
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.implementation.EspacioVerdeService;
import com.unla.grupo6.models.DisEspacioVerdeModel;
import com.unla.grupo6.models.DisEstacionamientoModel;
import com.unla.grupo6.models.DispositivoModel;
import com.unla.grupo6.servicies.IEspacioVerdeService;
import com.unla.grupo6.servicies.IEstacionamientoService;

@Controller
@RequestMapping("/espacioverde")
public class DisEspacioVerdeController {

	@Autowired
	@Qualifier("espacioVerdeService")
	private IEspacioVerdeService espacioVerdeService;

	@GetMapping("/index") // me lo muestra raro
	public String indexTest() {
		return ViewRouterHelper.ESPACIOVERDE_INDEX;
	}

//	// @PreAuthorize("hasRole('administrador')")
//	@GetMapping("estadoespacioverde")
//	public String estadoEspacioVerde() {
//		return "DisEspacioVerde/estadoEspacioVerde";
//	}
//
//	@GetMapping("/agregar/{sector}")
//	public ModelAndView agregarDisEspacioverde(@PathVariable("sector") String sector) {
//		ModelAndView mV = new ModelAndView(ViewRouterHelper.ESPACIOVERDE_AGREGAR);
//		mV.addObject("sector", sector);
//		return mV;
//	}
//
//	@PostMapping("/dispositivoAgregado")
//	public ModelAndView dispositivoAgregado(@Valid @ModelAttribute("agregar") DisEspacioVerdeModel nuevoDisEspacioVerde,
//			BindingResult bindingResult) {
//		ModelAndView mV = new ModelAndView();
//		if (bindingResult.hasErrors()) {
//			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGAR);
//		} else {
//			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGADO);
//			mV.addObject("agregar", nuevoDisEspacioVerde);
//		}
//		return mV;
//	}

//	@GetMapping("/crear")
//	public ModelAndView index() {
//		ModelAndView mAV = new ModelAndView(ViewRouterHelper.ESPACIOVERDE_CARGAR);
//		mAV.addObject("espaciosverdes", espacioVerdeService.getAll());
//		mAV.addObject("espacioverde", new DisEspacioVerdeModel());
//		return mAV;
//	}

	// @PreAuthorize("hasRole('administrador')") <- probablemente asi se desgine la

//	@PostMapping("/espacioverdeagregado") // me da al login sospecho que es por el model
//	public ModelAndView dispositivoAgregado(@Valid @ModelAttribute("agregar") DispositivoModel nuevoDispositivo,
//			BindingResult bindingResult) {
//		ModelAndView mV = new ModelAndView();
//		if (bindingResult.hasErrors()) {
//			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGAR);
//		} else {
//			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGADO);
//			mV.addObject("agregar", nuevoDispositivo);
//		}
//		return mV;
//	}

	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.ESPACIOVERDE_ROUTE_INDEX);
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		DisEspacioVerde disEspacioVerde = new DisEspacioVerde();
		model.addAttribute("titulo", "Formulario: Nuevo Sensor");
		model.addAttribute("espacio verde", disEspacioVerde);
		model.addAttribute("lista", espacioVerdeService.getAll());
		
		return ViewRouterHelper.ESPACIOVERDE_CREAR;
	}
	
	
	

	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute DisEspacioVerde disEspacioVerde, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
			model.addAttribute("espacio verde", disEspacioVerde);
			model.addAttribute("lista", espacioVerdeService.getAll());
			System.out.println("Existieron errores en el formulario");
			return ViewRouterHelper.ESPACIOVERDE_CREAR;
		}
		
		espacioVerdeService.saveVerde(disEspacioVerde);
		System.out.println("guardado con exito!");
		attribute.addFlashAttribute("success", "Dispositivo espacio verde ");
		return ViewRouterHelper.ESPACIOVERDE_REDIRECT_LISTA;

	}
	
	@GetMapping("/lista")
	public String listarBaños(Model model) {
		model.addAttribute("titulo", "Lista de sensores espacio verde");
		model.addAttribute("lista", espacioVerdeService.getAll());
		return ViewRouterHelper.BAÑO_LISTA;
	}
	
}
