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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.DisEspacioVerde;
import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.entities.Dispositivo;
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
	public String crearVerdes(Model model) {
		DisEspacioVerde disEspacioVerde = new DisEspacioVerde();
		model.addAttribute("titulo", "Formulario: Nuevo Sensor");
		model.addAttribute("espacioverde", disEspacioVerde);
		model.addAttribute("lista", espacioVerdeService.getAll());
		
		return ViewRouterHelper.ESPACIOVERDE_CREAR;
	}
	
	@GetMapping("/listaverde")
	public String listaVerdes(Model model) {
		model.addAttribute("titulo", "Lista de sensores espacio verde");
		model.addAttribute("lista", espacioVerdeService.getAll());
		return ViewRouterHelper.ESPACIOVERDE_LISTA;
	}
	
	@PostMapping("/save")
	public String guardarVerdes(@Valid @ModelAttribute DisEspacioVerde disEspacioVerde, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
			model.addAttribute("espacioverde", disEspacioVerde);
			model.addAttribute("lista", espacioVerdeService.getAll());
			System.out.println("Existieron errores en el formulario");
			return ViewRouterHelper.ESPACIOVERDE_CREAR;
		}
		
		if(disEspacioVerde.getHumedad() < 30) {
			disEspacioVerde.setBajaHumedad(true);
			disEspacioVerde.setRegando("Empezar regado");
			}else {
				disEspacioVerde.setBajaHumedad(false);
				disEspacioVerde.setRegando("No empezar el regado");
			}
		
		espacioVerdeService.saveVerde(disEspacioVerde);
		System.out.println("guardado con exito!");
		attribute.addFlashAttribute("success", "Dispositivo espacio verde ");
		return ViewRouterHelper.ESPACIOVERDE_REDIRECT_LISTA;
		}
		
		
		

	
	
	@GetMapping("listaverde/edit/{idDispositivo}")
	public String editar(@PathVariable("idDispositivo") Long idDispositivo, Model model, RedirectAttributes attribute ) {
		
		DisEspacioVerde disespacioverde = espacioVerdeService.buscarVerde(idDispositivo);
		model.addAttribute("titulo", "Formulario: Editar sensor espacio verde");
		model.addAttribute("espacioverde", disespacioverde);
		model.addAttribute("listaverde", espacioVerdeService.getAll());
		
		return ViewRouterHelper.ESPACIOVERDE_CREAR;
	}
	
	@GetMapping("listaverde/delete/{idDispositivo}")
	public String eliminar(@PathVariable("idDispositivo") Long idDispositivo, RedirectAttributes attribute) {
		espacioVerdeService.eliminarVerde(idDispositivo);
		System.out.println("Registro eliminado con exito");
		attribute.addFlashAttribute("warning", "Dispositivo eliminado con exito");
		return ViewRouterHelper.ESPACIOVERDE_REDIRECT_LISTA;
	}
	
	
	
//	@GetMapping("/sensores")
//	public String listarEspacioverde(Model modelo) {
//		modelo.addAttribute("espacioverde", espacioVerdeService.getAll());
//		return "espacioverde"; // nos retorna archivo estudiantes
//	}
//
//	
//	
//	
//	@GetMapping("sensores/nuevo")
//	public String mostrarFormularioDeEspacioVerde(Model modelo) {
//		DisEspacioVerde espacioverde = new DisEspacioVerde();
//		modelo.addAttribute("espacioverde", espacioverde);
//		return "DisEspacioVerde/agregarEspacioVerde";
//	}
//
//	@PostMapping("/sensores")
//	public String guardarEspacioVerde(@ModelAttribute("espacioverde") DisEspacioVerde espacioverde) {
//		espacioVerdeService.saveVerde(espacioverde);
//		return "redirect:/sensores";
//	}
//	
//	
//	
//

//	

//	
//	@GetMapping("listaverde/modificar/{id}")
//	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
//		modelo.addAttribute("disEspacioVerde", espacioVerdeService.buscarVerde(id));
//		return "modificarEspacioVerde";
//	}
//
//	@PostMapping("/listaverde/{id}")
//	public String actualizarEspacioVerde(@PathVariable Long id, @ModelAttribute("disEspacioVerde") DisEspacioVerde disEspacioVerde,
//			Model model) {
//		DisEspacioVerde espacioVerdeExistente = espacioVerdeService.buscarVerde(id);
//		espacioVerdeExistente.setIdDispositivo(id);
//		espacioVerdeExistente.setHumedad(disEspacioVerde.getHumedad());
//		espacioVerdeExistente.setSector(disEspacioVerde.getSector());
//		
//		espacioVerdeService.actualizarDisEspacioVerde(espacioVerdeExistente);
//		
//		return "redirect:/estudiantes";
//	}
	
}
