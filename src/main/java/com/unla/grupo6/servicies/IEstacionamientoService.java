package com.unla.grupo6.servicies;

import java.util.List;

import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.models.DisEstacionamientoModel;

public interface IEstacionamientoService {
	
	public List<DisEstacionamiento> getAll();
	
	public DisEstacionamientoModel insertOrUpdate(DisEstacionamientoModel objDisEstacionamiento);
	
}
