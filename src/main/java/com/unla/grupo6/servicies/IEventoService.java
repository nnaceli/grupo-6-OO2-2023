package com.unla.grupo6.servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.Evento;

@Service
public interface IEventoService {
	
	public List<Evento> getAll();
	public Evento saveEvento(Evento evento);
	public Evento buscar (long id);
}
