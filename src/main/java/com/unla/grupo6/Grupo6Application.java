package com.unla.grupo6;

import java.util.Iterator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.unla.grupo6.repositories.IEspacioVerdeRepository;
import com.unla.grupo6.repositories.IEstacionamientoRepository;
import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.DisEspacioVerde;
import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.entities.DisLucesAuto;
import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.implementation.BañoService;
import com.unla.grupo6.implementation.DisLucesAutoService;
import com.unla.grupo6.implementation.EspacioVerdeService;
import com.unla.grupo6.implementation.EstacionamientoService;
import com.unla.grupo6.implementation.EventoService;

@SpringBootApplication
@EnableScheduling
public class Grupo6Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Grupo6Application.class, args);
	}

	@Autowired
	private IEspacioVerdeRepository repositorioEspacioVerde;

	@Autowired
	private EstacionamientoService servicioEstacionamiento;
	
	@Autowired
	private EspacioVerdeService servicioEspacioVerde;
	
	@Autowired
	private DisLucesAutoService servicioLucesAuto;
	
	@Autowired
	private BañoService servicioBanios;
//	private EventoService servicioEvento;

////	@Override
//	public void run(String... args) throws Exception {
//
//
//		List<DisEstacionamiento> Estacionamientos = servicioEstacionamiento
//				.getPorSectorYfuncionamientoYtipo("29 de septiembre", true, 2);
//
//		for (DisEstacionamiento estacionamiento : Estacionamientos)
//			System.out.println(estacionamiento.toString());
//
//		//cargarDispositivosEstacionamiento();
//		if(servicioEstacionamiento.getAll().size() == 0) {
//			cargarDispositivosEstacionamiento();
//		}
//			
//
//
//		
//		// Carga automatica de dispositivos al inicializar el proyecto con la base de datos vacia
//		if(servicioEstacionamiento.getAll().size() == 0) {
//			cargarDispositivosEstacionamiento();
//		}
//		
//		if(servicioEspacioVerde.getAll().size() == 0) {
//			cargarDispositivosEspacioVerde();
//		}
//		
//		if(servicioLucesAuto.getAll().size() == 0) {
//			cargarDispositivosLucesAutomaticas();
//		}
//		
//		if(servicioBanios.getAll().size() == 0) {
//			cargarDispositivosBanios();
//		}

		
//		List<Evento> listEvento = servicioEvento.findByNombreDispositivo("Luz Automatica Hernandez");
//		for (Evento evento : listEvento)
//			System.out.println(evento.toString());
//	}
	
//	@Scheduled(cron = "*/3 * * * * *")
//	public void actualizarDispositivosDeEstacionamientos() {
//		servicioEstacionamiento.actualizarDisponibilidadEstacionamientos();
//	}
	

	private void cargarDispositivosEstacionamiento() {
		
		String sectorAcargar="";
		//carga de dispositivos para estacionamientos
		for(int i=0; i<4; i++) {
			
			switch(i) {
				case 0: sectorAcargar="Buffet"; break;
				case 1: sectorAcargar="29 de Septiembre"; break;
				case 2: sectorAcargar="Pablo Nogues"; break;
				case 3: sectorAcargar="José Malba"; break;
			}
			
			for(int j=0; j<10; j++) {
				servicioEstacionamiento.insert(new DisEstacionamiento("DisEstacionamiento", true, false, false, sectorAcargar, 1));
			}
			
			for(int z=0; z<4; z++) {
				servicioEstacionamiento.insert(new DisEstacionamiento("DisEstacionamiento", true, false, false, sectorAcargar, 2));
			}
		}
	}
	
	private void cargarDispositivosEspacioVerde() {
		
		String regando = "Desactivado";
		servicioEspacioVerde.saveVerde(new DisEspacioVerde("DisEspacioVerde", true, false, true, 0, "Plaza Abuelas", regando));
		servicioEspacioVerde.saveVerde(new DisEspacioVerde("DisEspacioVerde", true, false, true, 0, "Plaza Malvinas", regando));
		servicioEspacioVerde.saveVerde(new DisEspacioVerde("DisEspacioVerde", true, false, true, 0, "Plaza del 10", regando));
	}
	
	private void cargarDispositivosLucesAutomaticas() {
		servicioLucesAuto.save(new DisLucesAuto("Luz Automatica Hernandez", true, false, false, 11));
		servicioLucesAuto.save(new DisLucesAuto("Luz Automatica Scalabrini", true, false, false, 1));
		servicioLucesAuto.save(new DisLucesAuto("Luz Automatica Nestor Kirchner", true, false, false, 6));
	}
	
	private void cargarDispositivosBanios() {
		servicioBanios.save(new DisBaño("Dispositivo Baño Mujer", true, false, true, false, "Arturo Jauretche"));
		servicioBanios.save(new DisBaño("Dispositivo Baño Hombre", true, false, true, false, "Manuel Ugarte"));
		servicioBanios.save(new DisBaño("Dispositivo Baño Hombre", true, false, true, false, "Jose Hernandez"));
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
