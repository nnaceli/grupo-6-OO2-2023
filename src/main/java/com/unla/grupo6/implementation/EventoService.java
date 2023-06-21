package com.unla.grupo6.implementation;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.Dispositivo;
import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.repositories.IEventoRepository;
import com.unla.grupo6.servicies.IEventoService;

import java.time.LocalDateTime;
import java.util.List;

@Service("eventoService")
public class EventoService implements IEventoService {
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	@Override
	public List<Evento> getAll(){
		return eventoRepository.findAll();
	}
	
	@Override
	public List<Evento> getAll(String palabraClave) {
		if(palabraClave != null) {
			return eventoRepository.getAll(palabraClave);
		}
		return eventoRepository.findAll();
	}
		
	public List<Evento> getAllEntreFechas(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		return eventoRepository.findByfechaHoraBetween(fechaDesde, fechaHasta);
	}

	@Override
	public List<Evento> getAllPorDipositivo(Dispositivo dispositivo) {
		return eventoRepository.findByDispositivo(dispositivo);
	}
	
	/*
	 * @Override public List<Evento> findByNombreDispositivo(String nombre) { return
	 * eventoRepository.findByNombreDispositivo(nombre);
	 * 
	 * }
	 */
	
	public Evento saveEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	public Evento buscar(long id) {
		return eventoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Evento> findByNombreDispositivo(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
