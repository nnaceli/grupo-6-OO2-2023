package com.unla.grupo6.servicies;
import java.util.List;

import com.unla.grupo6.entities.Dispositivo;
import com.unla.grupo6.models.DispositivoModel;

public interface IDispositivoService {
	public List <Dispositivo> getAll();
	
	public Dispositivo findByIdDispositivo(int idDispositivo);
	
	public DispositivoModel findByNombre (String nombre);
	
	public List<DispositivoModel> findByDispositivoNombre (String dispositivoNombre);
}
