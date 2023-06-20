package com.unla.grupo6.servicies;

import java.util.List;

import com.unla.grupo6.entities.DisLucesAuto;
import com.unla.grupo6.models.DisLucesAutoModel;


public interface ILucesAutoService {

	
	public List<DisLucesAuto> getAll();

	public void save(DisLucesAuto disLucesAuto);
	
	public void remove(int id);

	public DisLucesAuto buscar(long id);

	public DisLucesAutoModel insertOrUpdate(DisLucesAutoModel disLucesAutoModel);
	
	public List<DisLucesAuto> getByBaja(boolean baja);

}
