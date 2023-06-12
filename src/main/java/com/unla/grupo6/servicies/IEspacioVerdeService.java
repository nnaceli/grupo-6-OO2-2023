package com.unla.grupo6.servicies;

import java.util.List;

import com.unla.grupo6.entities.DisEspacioVerde;
import com.unla.grupo6.models.DisEspacioVerdeModel;

public interface IEspacioVerdeService {

	public List<DisEspacioVerde> getAll();

	public DisEspacioVerdeModel insertOrUpdate(DisEspacioVerdeModel disEspacioVerdeModel);

	public boolean remove(int id);
}
