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
import org.springframework.web.servlet.view.RedirectView;

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
	
//	@GetMapping("helloWorld")
//	public String helloWorld() {
//		return "DisEspacioVerde/helloWorld";
//	}
	
	@Autowired
	@Qualifier("espacioVerdeService")
	private IEspacioVerdeService espacioVerdeService;
	
	
	@GetMapping("/index") //me lo muestra raro
	public String indexTest() {
		return ViewRouterHelper.ESPACIOVERDE_INDEX;
	}
	
	//@PreAuthorize("hasRole('administrador')")
	@GetMapping("estadoespacioverde")
	public String estadoEspacioVerde() {
		return "DisEspacioVerde/estadoEspacioVerde";
	}
	
	@GetMapping("/agregar/{sector}") 
	public ModelAndView agregarDisEspacioverde(@PathVariable("sector") String sector) {
		ModelAndView mV = new ModelAndView(ViewRouterHelper.ESPACIOVERDE_AGREGAR);
		mV.addObject("sector", sector);
		return mV;
	}
	
	@GetMapping("/agregar")
	public String agregarDisEstacionamiento(Model model) {
		model.addAttribute("agregar", new DisEspacioVerdeModel());
		return ViewRouterHelper.ESPACIOVERDE_AGREGAR;
	}
	
	@PostMapping("/dispositivoAgregado")
	public ModelAndView dispositivoAgregado(@Valid @ModelAttribute("agregar") DisEspacioVerdeModel nuevoDisEspacioVerde, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGAR);
		}else {
			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGADO);
			mV.addObject("agregar", nuevoDisEspacioVerde);
		}
		return mV;
	}
	
	@GetMapping("/cargar")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouterHelper.ESPACIOVERDE_CARGAR);
		mAV.addObject("espaciosverdes", espacioVerdeService.getAll());
		mAV.addObject("espacioverde", new DisEspacioVerdeModel());
		return mAV;
	}
	
	
	//@PreAuthorize("hasRole('administrador')") <- probablemente asi se desgine la manera de donde un admin o auditor puede ingresar a la vista
//	@GetMapping("/agregar") //ME DABA ERROR PORQUE HAY UN PROBLEMAS CON LOS IMPUTS DE ESTE TEMPLATE LO SAQUE Y FUNCIONO SIN PROBLEMAS PERRO
//	public String agregarDisEspacioVerde(Model model) {
//		model.addAttribute("agregar", new DisEspacioVerdeModel(0, null, null, false, false, 0, null));
//		return ViewRouterHelper.ESPACIOVERDE_AGREGAR;
//	}
	
	
	@PostMapping("/espacioverdeagregado") //me da al login sospecho que es por el model
	public ModelAndView dispositivoAgregado(@Valid @ModelAttribute("agregar") DispositivoModel nuevoDispositivo, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGAR);
		} else {
			mV.setViewName(ViewRouterHelper.ESPACIOVERDE_AGREGADO);
			mV.addObject("agregar", nuevoDispositivo);
		}
		return mV;
	}
	
	
	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.ESPACIOVERDE_ROUTE_INDEX);
	}
	
	
	
	
	
//	@Autowired
//	@Qualifier("espacioVerdeService")
	//private IEspacioVerdeService espacioVerdeService; //buscar como hacer que neceisot para que funcione
	
	//private ModelMapper modelMapper = new ModelMapper();
	
//	@GetMapping("")
//	public ModelAndView index1() {
//		ModelAndView mAV = new ModelAndView(ViewRouterHelper.ESPACIOVERDE_INDEX); //por que no me lo reconoce y me pide un archivo del tfi gustavo?
//		mAV.addObject("espaciosVerdes", espacioVerdeService.getAll());
//		return mAV;
//	}
	
	

}
