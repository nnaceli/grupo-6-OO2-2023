package com.unla.grupo6.controllers;

import java.time.LocalDateTime;
import java.util.Random;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo6.entities.DisLucesAuto;
import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.helpers.ViewRouterHelper;
import com.unla.grupo6.servicies.IEventoService;
import com.unla.grupo6.servicies.ILucesAutoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/lucesautomaticas")
public class DisLucesAutoController {

//	@GetMapping("/helloworld")
//	public String helloWorld() {
//		return ViewRouterHelper.LUCES_HOLA;
//	}

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@Autowired
	private ILucesAutoService lucesService;

	@GetMapping("/index")
	public String index() {
		return ViewRouterHelper.LUCES_INDEX;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/agregarLuces")
	public String agregar(Model model) {
		DisLucesAuto disLucesAuto = new DisLucesAuto();
		model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
		model.addAttribute("disLucesAuto", disLucesAuto);
		model.addAttribute("lista", lucesService.getAll());
		return ViewRouterHelper.LUCES_AGREGAR;
	}

	@GetMapping("/listaLucesAuto")
	public String listarLuces(Model model) {
		model.addAttribute("titulo", "Lista de Luces Automáticas");
		model.addAttribute("lista", lucesService.getByBaja(false));
		return ViewRouterHelper.LUCES_AGREGADAS;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute DisLucesAuto disLucesAuto, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Dispositivo");
			model.addAttribute("lucesautomaticas", disLucesAuto);
			model.addAttribute("lista", lucesService.getAll());
			System.out.println("Existieron errores en el formulario");
			return ViewRouterHelper.LUCES_AGREGAR;
		}

		lucesService.save(disLucesAuto);
		attribute.addFlashAttribute("correcta", "Dispositivo Luces Automaticas guardado de forma ");
		return ViewRouterHelper.LUCES_REDIRECT_AGREGADAS;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listaLucesAuto/modificarLuces/{idDispositivo}")
	public String modificar(@PathVariable("idDispositivo") Long idDispositivo, Model model) {
		DisLucesAuto disLucesAuto = lucesService.buscar(idDispositivo);
		model.addAttribute("titulo", "Formulario: Modificar Dispositivo");
		model.addAttribute("disLucesAuto", disLucesAuto);
		model.addAttribute("lista", lucesService.getAll());

		return ViewRouterHelper.LUCES_AGREGAR;
	}

	@PreAuthorize("hasRole('ROLE_AUDITOR')")
	@GetMapping("listaLucesAuto/verAula/{idDispositivo}")
	public String verCamara(@PathVariable("idDispositivo") Long idDispositivo, Model model,
			RedirectAttributes attribute) {

		DisLucesAuto disLucesAuto = lucesService.buscar(idDispositivo);

		Random random = new Random();
		boolean randomValue = random.nextBoolean();
		disLucesAuto.setEstado(randomValue);
		lucesService.save(disLucesAuto);

		if (disLucesAuto.isEnFuncionamiento() == false) {
			attribute.addFlashAttribute("error",
					"ATENCION: La camara del aula seleccionada no se puede ver porque no funciona");
			return ViewRouterHelper.LUCES_REDIRECT_AGREGADAS;
		}

		model.addAttribute("titulo", "Ver Aula");
		model.addAttribute("disLucesAuto", disLucesAuto);

		Evento nuevoEvento = new Evento(disLucesAuto, LocalDateTime.now(), disLucesAuto.getNombre());
		eventoService.saveEvento(nuevoEvento);
		return ViewRouterHelper.LUCES_VER_AULA;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("listaLucesAuto/eliminarLuces/{idDispositivo}")
	public String eliminar(@PathVariable("idDispositivo") Long idDispositivo, RedirectAttributes attribute) {
		DisLucesAuto disLucesAuto = lucesService.buscar(idDispositivo);

		// Realiza la baja lógica del dispositivo
		disLucesAuto.setBaja(true);
		lucesService.save(disLucesAuto);

		attribute.addFlashAttribute("success",
				"El dispositivo de luces automáticas ha sido dado de baja correctamente");
		return ViewRouterHelper.LUCES_REDIRECT_AGREGADAS;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIntex() {
		return new RedirectView(ViewRouterHelper.LUCES_INDEX);
	}

}