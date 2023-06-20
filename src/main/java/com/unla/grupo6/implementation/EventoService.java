package com.unla.grupo6.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.repositories.IEventoRepository;

import java.util.List;

@Service("eventoService")
public class EventoService {
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	//traer todos los evnetos (Creo)
	public List<Evento> getAll(){
		return eventoRepository.findAll();
	}
	
	public Evento saveEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public Evento getEventoById (int id) {
		return eventoRepository.findById(id).orElse(null);
	}
}
