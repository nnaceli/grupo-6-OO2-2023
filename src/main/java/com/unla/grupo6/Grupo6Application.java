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
import com.unla.grupo6.entities.DisEspacioVerde;
import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.entities.DisLucesAuto;
import com.unla.grupo6.entities.Evento;
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
//	private EventoService servicioEvento;

//	@Override
	public void run(String... args) throws Exception {

		List<DisEstacionamiento> Estacionamientos = servicioEstacionamiento
				.getPorSectorYfuncionamientoYtipo("29 de septiembre", true, 2);

		for (DisEstacionamiento estacionamiento : Estacionamientos)
			System.out.println(estacionamiento.toString());
		
//		List<Evento> listEvento = servicioEvento.findByNombreDispositivo("Luz Automatica Hernandez");
//		for (Evento evento : listEvento)
//			System.out.println(evento.toString());
	}
	
//	@Scheduled(cron = "*/3 * * * * *")
//	public void generarEventoDispositivoEstacionamiento() {
//		servicioEstacionamiento.actualizarDisponibilidadEstacionamientos();
//	}
}
