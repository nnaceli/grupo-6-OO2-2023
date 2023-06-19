package com.unla.grupo6.servicies;

import java.util.List;

import com.unla.grupo6.entities.DisEstacionamiento;

public interface IEstacionamientoService {
	
	public List<DisEstacionamiento> getAll();
	
	public DisEstacionamiento insertOrUpdate(DisEstacionamiento objDisEstacionamiento);
	
	public DisEstacionamiento obtenerEstacionamiento(Long id);
	
	public void eliminarEstacionamiento(Long id);
	
}
