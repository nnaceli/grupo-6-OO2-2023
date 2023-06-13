package com.unla.grupo6.controllers;

import javax.validation.Valid;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.models.DisEspacioVerdeModel;
import com.unla.grupo6.models.DisEstacionamientoModel;
import com.unla.grupo6.models.DispositivoModel;

@Controller
@RequestMapping("/espacioverde")
public class DisEspacioVerdeController {
	
//	@GetMapping("helloWorld")
//	public String helloWorld() {
//		return "DisEspacioVerde/helloWorld";
//	}
	
	@GetMapping("/index") //me lo muestra raro
	public String index() {
		return ViewRouterHelper.ESPACIOVERDE_INDEX;
	}
	
	@GetMapping("estadoespacioverde")
	public String estadoEspacioVerde() {
		return "DisEspacioVerde/estadoEspacioVerde";
	}
	
	@GetMapping("/agregar/{sector}") //me da al login sospecho que es por el model
	public ModelAndView agregarDisEspacioverde(@PathVariable("sector") String sector) {
		ModelAndView mV = new ModelAndView(ViewRouterHelper.ESPACIOVERDE_AGREGAR);
		mV.addObject("sector", sector);
		return mV;
	}
	
	@GetMapping("/agregar") //ME DABA ERROR PORQUE HAY UN PROBLEMAS CON LOS IMPUTS DE ESTE TEMPLATE LO SAQUE Y FUNCIONO SIN PROBLEMAS PERRO
	public String agregarDisEspacioVerde(Model model) {
		model.addAttribute("agregar", new DisEspacioVerdeModel());
		return ViewRouterHelper.ESPACIOVERDE_AGREGAR;
	}
	
	
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
