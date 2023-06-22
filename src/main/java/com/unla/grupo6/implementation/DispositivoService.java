package com.unla.grupo6.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.Dispositivo;
import com.unla.grupo6.models.DispositivoModel;
import com.unla.grupo6.repositories.IDispositivoRepository;
import com.unla.grupo6.servicies.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {

	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;
	
	//private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	
	}

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DispositivoModel findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DispositivoModel> findByDispositivoNombre(String dispositivoNombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
