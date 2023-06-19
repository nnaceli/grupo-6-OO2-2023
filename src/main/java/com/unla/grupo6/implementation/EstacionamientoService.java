package com.unla.grupo6.implementation;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//import com.unla.grupo6.converts.DisEstacionamientoConvert;
import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.models.DisEstacionamientoModel;
import com.unla.grupo6.repositories.IEstacionamientoRepository;
import com.unla.grupo6.servicies.IEstacionamientoService;

@Service("estacionamientoService")
public class EstacionamientoService implements IEstacionamientoService{

	@Autowired
	@Qualifier("estacionamientoRepository")
	private IEstacionamientoRepository estacionamientoRepository;
	
//	@Autowired
//	@Qualifier("disEstacionamientoConvert")
//	private DisEstacionamientoConvert disEstacionamientoConvert;
	

	
	@Override
	public List<DisEstacionamiento> getAll() {
		return estacionamientoRepository.findAll();
	}

	@Override
	public DisEstacionamiento insertOrUpdate(DisEstacionamiento objDisEstacionamiento) {
		return estacionamientoRepository.save(objDisEstacionamiento);
	}

	@Override
	public DisEstacionamiento obtenerEstacionamiento(Long id) {
		return estacionamientoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarEstacionamiento(Long id) {
		estacionamientoRepository.deleteById(id);
	}

}
