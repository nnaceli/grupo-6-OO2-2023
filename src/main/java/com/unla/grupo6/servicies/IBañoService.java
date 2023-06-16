package com.unla.grupo6.servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.DisBaño;


@Service
public interface IBañoService {
	public List<DisBaño> getAll();
	public DisBaño buscar(long id);
	public void eliminar(Long id);
	public void save(DisBaño disBaño);
	
}
