//ESTA COMENTADO PORQUE ME SALE UN ERROR QUE YA LE PREGUNTE A GUS PO REL CAMPUS
//CAPAZ TENGAMOS QUE BORRAR ESTO
package com.unla.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.servicies.IDispositivoService;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {

	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	// BUSCAR DE DONDE SACO ESTO
	// private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/index")
	public String index(Model model) {

		model.addAttribute("titulo", "Menu de Dispositivos");
		model.addAttribute("dispositivos", dispositivoService.getAll());

		return ViewRouterHelper.DISPOSITIVO_INDEX;
	}
}
