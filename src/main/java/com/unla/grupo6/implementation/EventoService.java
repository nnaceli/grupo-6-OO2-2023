package com.unla.grupo6.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.Evento;
import com.unla.grupo6.repositories.IEventoRepository;
import com.unla.grupo6.servicies.IEventoService;

import java.util.List;

@Service("eventoService")
public class EventoService implements IEventoService {
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	public List<Evento> getAll(){
		return eventoRepository.findAll();
	}
	
	public Evento saveEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	

	@Override
	public Evento buscar(long id) {
		return eventoRepository.findById(id).orElse(null);
	}
}
