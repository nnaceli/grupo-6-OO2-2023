package com.unla.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo6.helpers.ViewRouterHelper;

@Controller
@RequestMapping("/espacioverde")
public class DisEspacioVerdeController {
	
	@GetMapping("helloWorld")
	public String helloWorld() {
		return "DisEspacioVerde/helloWorld";
	}
	
	@GetMapping("index")
	public String index() {
		return "DisEspacioVerde/index";
	}
	
	
//	@Autowired
//	@Qualifier("espacioVerdeService")
	//private IEspacioVerdeService espacioVerdeService; //buscar como hacer que neceisot para que funcione
	
	//private ModelMapper modelMapper = new ModelMapper();
	
//	@GetMapping("")
//	public ModelAndView index() {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ESPACIOVERDE_INDEX); //por que no me lo reconoce y me pide un archivo del tfi gustavo?
//		mAV.addObject("espaciosVerdes", espacioVerdeService.getAll());
//		return mAV;
//	}
	
	

}
