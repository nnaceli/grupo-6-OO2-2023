package com.unla.grupo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unla.grupo6.repositories.IEspacioVerdeRepository;
import com.unla.grupo6.entities.DisEspacioVerde;

@SpringBootApplication
public class Grupo6Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Grupo6Application.class, args);
	}

	
	@Autowired
	private IEspacioVerdeRepository repositorioEspacioVerde;
	
//	@Override
	public void run(String... args) throws Exception{
		
//		DisEspacioVerde disespacioverde = new DisEspacioVerde("sensor prueba", "carga de datos con metodo run", true, true, 30, "plaza abuelas");
//		repositorioEspacioVerde.save(disespacioverde);
//		
//		DisEspacioVerde disespacioverde2 = new DisEspacioVerde("sensor arbusto", "sensor que mide humedad arbusto", true, true, 70, "plaza malvinas");
//		repositorioEspacioVerde.save(disespacioverde2);
	}
}
