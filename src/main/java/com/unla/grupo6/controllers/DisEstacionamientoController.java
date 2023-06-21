package com.unla.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.servicies.IEstacionamientoService;

@Controller
@RequestMapping("/estacionamientos")
public class DisEstacionamientoController {

	@Autowired
	@Qualifier("estacionamientoService")
	private IEstacionamientoService estacionamientoService;

	@GetMapping({ "/index", "/" })
	public String index() {
		return ViewRouterHelper.ESTACIONAMIENTO_INDEX;
	}

	@GetMapping("/listaDispositivos")
	public String listarDisEstacionamiento(Model modelo) {
		modelo.addAttribute("estacionamientos", estacionamientoService.getAll());
		return ViewRouterHelper.ESTACIONAMIENTO_LISTA;
	}

	// SECTOR 29 DE SEPTIEMBRE
	@GetMapping("/septiembre")
	public String septiembre() {
		return ViewRouterHelper.ESTACIONAMIENTO_SECTOR_SEPTIEMBRE;
	}

	@GetMapping("/septiembre/comunes")
	public String plazasSectorSeptiembreNormales(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("29 de septiembre", true, 1));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_COMUNES;
	}

	@GetMapping("/septiembre/discapacitados")
	public String plazasSectorSeptiembreDiscapactiados(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("29 de septiembre", true, 2));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_DISCAPACITADOS;
	}

	// SECTOR BUFFET
	@GetMapping("/buffet")
	public String buffet() {
		return ViewRouterHelper.ESTACIONAMIENTO_SECTOR_BUFFET;
	}

	@GetMapping("/buffet/comunes")
	public String plazasSectorBuffetNormales(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("Buffet", true, 1));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_COMUNES;
	}

	@GetMapping("/buffet/discapacitados")
	public String plazasSectorBuffetDiscapactiados(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("Buffet", true, 2));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_DISCAPACITADOS;
	}

	// SECTOR JOSE MALBA
	@GetMapping("/jose")
	public String malba() {
		return ViewRouterHelper.ESTACIONAMIENTO_SECTOR_JOSE;
	}

	@GetMapping("/jose/comunes")
	public String plazasSectorJoseNormales(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("José Malba", true, 1));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_COMUNES;
	}

	@GetMapping("/jose/discapacitados")
	public String plazasSectorJoseDiscapactiados(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("José Malba", true, 2));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_DISCAPACITADOS;
	}

	// SECTOR PABLO NOGUES
	@GetMapping("/pablo")
	public String pablo() {
		return ViewRouterHelper.ESTACIONAMIENTO_SECTOR_PABLO;
	}

	@GetMapping("/pablo/comunes")
	public String plazasSectorPabloNormales(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("Pablo Nogues", true, 1));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_COMUNES;
	}

	@GetMapping("/pablo/discapacitados")
	public String plazasSectorPabloDiscapactiados(Model modelo) {
		modelo.addAttribute("estacionamientos",
				estacionamientoService.getPorSectorYfuncionamientoYtipo("Pablo Nogues", true, 2));
		return ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_DISCAPACITADOS;
	}

	@GetMapping("/agregar")
	public String mostrarFormularioDeAgregarDispositivo(Model modelo) {
		DisEstacionamiento disEstacionamiento = new DisEstacionamiento();
		modelo.addAttribute("estacionamiento", disEstacionamiento);
		return ViewRouterHelper.ESTACIONAMIENTO_AGREGAR;
	}

	@PostMapping("/guardar")
	public String agregar(@ModelAttribute("estacionamiento") DisEstacionamiento nuevoEstacionamiento) {
		estacionamientoService.insertOrUpdate(nuevoEstacionamiento);
		return ViewRouterHelper.ESTACIONAMIENTO_REDIRECT_LISTA;
	}

	@GetMapping("/editar/{idDispositivo}")
	public String mostrarFormularioDeEditar(@PathVariable Long idDispositivo, Model modelo) {
		modelo.addAttribute("estacionamiento", estacionamientoService.obtenerEstacionamiento(idDispositivo));
		return ViewRouterHelper.ESTACIONAMIENTO_MODIFICAR;
	}

	@PostMapping("/{idDispositivo}")
	public String actualizarEstacionamiento(@PathVariable Long idDispositivo,
			@ModelAttribute("estacionamiento") DisEstacionamiento disEstacionamiento, Model model) {
		DisEstacionamiento disEstacionamientoExistente = estacionamientoService.obtenerEstacionamiento(idDispositivo);
		disEstacionamientoExistente.setIdDispositivo(idDispositivo);
		disEstacionamientoExistente.setSector(disEstacionamiento.getSector());
		disEstacionamientoExistente.setEnFuncionamiento(disEstacionamiento.isEnFuncionamiento());
		disEstacionamientoExistente.setOcupado(disEstacionamiento.isOcupado());
		disEstacionamientoExistente.setTipoEstacionamiento(disEstacionamiento.getTipoEstacionamiento());

		estacionamientoService.insertOrUpdate(disEstacionamientoExistente);

		return ViewRouterHelper.ESTACIONAMIENTO_REDIRECT_LISTA;
	}

	@GetMapping("/baja/{idDispositivo}")
	public String darDeBajaEstacionamiento(@PathVariable Long idDispositivo) {
		DisEstacionamiento disEstacionamiento = estacionamientoService.obtenerEstacionamiento(idDispositivo);
		disEstacionamiento.setEnFuncionamiento(false);
		estacionamientoService.insertOrUpdate(disEstacionamiento);
		return ViewRouterHelper.ESTACIONAMIENTO_REDIRECT_LISTA;
	}

	@GetMapping("/alta/{idDispositivo}")
	public String darDeAltaEstacionamiento(@PathVariable Long idDispositivo) {
		DisEstacionamiento disEstacionamiento = estacionamientoService.obtenerEstacionamiento(idDispositivo);
		disEstacionamiento.setEnFuncionamiento(true);
		estacionamientoService.insertOrUpdate(disEstacionamiento);
		return ViewRouterHelper.ESTACIONAMIENTO_REDIRECT_LISTA;
	}

	/*
	 * @GetMapping("/{id}") public String eliminarEstudiante(@PathVariable Long id)
	 * { servicio.eliminarEstudiante(id); return "redirect:/estudiantes"; }
	 * 
	 * 
	 * @GetMapping("/estacionamientoDisponibles") public String
	 * estacionamientoDisponibles() { return
	 * "DisEstacionamiento/estacionamientosGeneral"; }
	 * 
	 * @GetMapping("/plazasDisponibles") public String plazasDisponibles() { return
	 * ViewRouterHelper.ESTACIONAMIENTO_PLAZAS_DISPONIBLES;
	 * 
	 * }
	 * 
	 * @GetMapping("/agregar") public String agregarDisEstacionamiento(Model model)
	 * { model.addAttribute("agregar", new DisEstacionamientoModel()); return
	 * ViewRouterHelper.ESTACIONAMIENTO_AGREGAR; }
	 * 
	 * @PostMapping("/dispositivoAgregado") public ModelAndView
	 * dispositivoAgregado(@Valid @ModelAttribute("agregar") DisEstacionamientoModel
	 * nuevoDisEstacionamiento, BindingResult bindingResult) { ModelAndView mV = new
	 * ModelAndView(); if(bindingResult.hasErrors()) {
	 * mV.setViewName(ViewRouterHelper.ESTACIONAMIENTO_AGREGAR); }else {
	 * mV.setViewName(ViewRouterHelper.ESTACIONAMIENTO_AGREGADO);
	 * mV.addObject("agregar", nuevoDisEstacionamiento); } return mV; }
	 * 
	 * @GetMapping("/modificar") public String modificar() { return
	 * ViewRouterHelper.ESTACIONAMIENTO_MODIFICAR; }
	 * 
	 * @GetMapping("/eliminar") public String eliminar() { return
	 * ViewRouterHelper.ESTACIONAMIENTO_ELIMINAR;
	 * 
	 * }
	 */

}
