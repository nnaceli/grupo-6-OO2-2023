package com.unla.grupo6.servicies;

import java.util.List;



import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.DisEspacioVerde;
import com.unla.grupo6.models.DisEspacioVerdeModel;

import jakarta.validation.Valid;

public interface IEspacioVerdeService {

	public List<DisEspacioVerde> getAll();

	public DisEspacioVerdeModel insertOrUpdate(DisEspacioVerdeModel disEspacioVerdeModel);

	public DisEspacioVerde buscarVerde(long id);

	public void eliminarVerde(long id);

	public void saveVerde(@Valid DisEspacioVerde disEspacioVerde);
	
	public DisEspacioVerde actualizarDisEspacioVerde(DisEspacioVerde disEspacioVerde);






}
