package com.unla.grupo6.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.repositories.IBañoRepository;
import com.unla.grupo6.servicies.IBañoService;

@Service("bañoService")
public class BañoService implements IBañoService {
	
	@Autowired
	@Qualifier("bañoRepository")
	private IBañoRepository bañoRepository;
	
	@Override
	public List<DisBaño> getAll() {
		return bañoRepository.findAll();
	}

	@Override
	public DisBaño buscar(long id) {
		return bañoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		bañoRepository.deleteById(id);

	}

	@Override
	public void save(DisBaño disBaño) {
		bañoRepository.save(disBaño);
	}
	
	
	

	
	

}
