package com.unla.grupo6.controllers;




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

import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.models.DisEstacionamientoModel;
import com.unla.grupo6.servicies.IEstacionamientoService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/estacionamientos")
public class DisEstacionamientoController {
	
	@Autowired
	@Qualifier("estacionamientoService")
	private IEstacionamientoService estacionamientoService;

	
	//usar el contructor vacio de entities 
	@GetMapping("/listaDispositivos")
	public String listarDisEstacionamiento(Model modelo) {
		modelo.addAttribute("titulo", "Lista de Estacionamientos");
		modelo.addAttribute("estacionamientos", estacionamientoService.getAll());
		return "DisEstacionamiento/lista_dispositivos";
	}
	

	@GetMapping("/agregar")
	public String mostrarFormularioDeAgregarDispositivo(Model modelo) {
		DisEstacionamiento disEstacionamiento = new DisEstacionamiento();
		modelo.addAttribute("estacionamiento", disEstacionamiento);
		return "DisEstacionamiento/agregar_dispositivo";
	}
	
	
	@PostMapping("/guardar")
	public String agregar(@ModelAttribute("estacionamiento") DisEstacionamiento nuevoEstacionamiento) {
		estacionamientoService.insertOrUpdate(nuevoEstacionamiento);
		return "redirect:listaDispositivos";
	}
	
	@GetMapping("/editar/{idDispositivo}")
	public String mostrarFormularioDeEditar(@PathVariable Long idDispositivo, Model modelo) {
		modelo.addAttribute("estacionamiento", estacionamientoService.obtenerEstacionamiento(idDispositivo));
		return "DisEstacionamiento/modificar_dispositivo";
	}

	@PostMapping("/{idDispositivo}")
	public String actualizarEstacionamiento(@PathVariable Long idDispositivo, @ModelAttribute("estacionamiento") DisEstacionamiento disEstacionamiento,
			Model model) {
		DisEstacionamiento disEstacionamientoExistente = estacionamientoService.obtenerEstacionamiento(idDispositivo);
		disEstacionamientoExistente.setIdDispositivo(idDispositivo);
		disEstacionamientoExistente.setSector(disEstacionamiento.getSector());
		disEstacionamientoExistente.setEnFuncionamiento(disEstacionamiento.isEnFuncionamiento());
		disEstacionamientoExistente.setOcupado(disEstacionamiento.isOcupado());
		disEstacionamientoExistente.setTipoEstacionamiento(disEstacionamiento.getTipoEstacionamiento());
		
		estacionamientoService.insertOrUpdate(disEstacionamientoExistente);
		
		return "redirect:/estacionamientos/listaDispositivos";
	}
	
	@GetMapping("/{id}")
	public String eliminarEstacionamiento(@PathVariable Long id) {
		estacionamientoService.eliminarEstacionamiento(id);
		return "redirect:/estacionamientos/listaDispositivos";
	}
	
	/*
	@GetMapping("/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
	
	@GetMapping("/estacionamientoDisponibles")
	public String estacionamientoDisponibles() {
		return "DisEstacionamiento/estacionamientosGeneral";
	}

	@GetMapping("/plazasDisponibles")
	public String plazasDisponibles() {
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_DISPONIBLES;

	}
	
	@GetMapping("/agregar")
	public String agregarDisEstacionamiento(Model model) {
		model.addAttribute("agregar", new DisEstacionamientoModel());
		return ViewRouterHelper.ESTACIONAMIENTO_AGREGAR;
	}
	
	@PostMapping("/dispositivoAgregado")
	public ModelAndView dispositivoAgregado(@Valid @ModelAttribute("agregar") DisEstacionamientoModel nuevoDisEstacionamiento, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mV.setViewName(ViewRouterHelper.ESTACIONAMIENTO_AGREGAR);
		}else {
			mV.setViewName(ViewRouterHelper.ESTACIONAMIENTO_AGREGADO);
			mV.addObject("agregar", nuevoDisEstacionamiento);
		}
		return mV;
	}
	
	@GetMapping("/modificar")
	public String modificar() {
		return ViewRouterHelper.ESTACIONAMIENTO_MODIFICAR;
	}
	
	@GetMapping("/eliminar")
	public String eliminar() {
		return ViewRouterHelper.ESTACIONAMIENTO_ELIMINAR;

	}*/

}
