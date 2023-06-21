package com.unla.grupo6.servicies;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.Dispositivo;
import com.unla.grupo6.entities.Evento;

@Service
public interface IEventoService {
	
	public List<Evento> getAll();

	
	public List<Evento> getAll(String palabraClave);

	public List<Evento> getAllEntreFechas(LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	public List<Evento> getAllPorDipositivo(Dispositivo dispositivo);
	public List<Evento> findByNombreDispositivo(String nombre);

	
	public Evento saveEvento(Evento evento);
	public Evento buscar (long id);
}
