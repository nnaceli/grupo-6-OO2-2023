package com.unla.grupo6.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.repositories.IEstacionamientoRepository;
import com.unla.grupo6.servicies.IEstacionamientoService;

@Service("estacionamientoService")
public class EstacionamientoService implements IEstacionamientoService{
	
	@Autowired
	@Qualifier("estacionamientoRepository")
	private IEstacionamientoRepository estacionamientoRepository;
	
	@Override
	public List<DisEstacionamiento> getAll() {
		return estacionamientoRepository.findAll();
	}
}