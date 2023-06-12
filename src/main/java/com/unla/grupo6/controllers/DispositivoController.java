//ESTA COMENTADO PORQUE ME SALE UN ERROR QUE YA LE PREGUNTE A GUS PO REL CAMPUS

package com.unla.grupo6.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.servicies.IDispositivoService;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {	
	
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	 
	//BUSCAR DE DONDE SACO ESTO 
	//private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouterHelper.DISPOSITIVO_INDEX);
		mAV.addObject("dispositivos", dispositivoService.getAll());
	return mAV;
	}
}


