package com.unla.grupo6.implementation;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.DisEspacioVerde;
import com.unla.grupo6.models.DisEspacioVerdeModel;
import com.unla.grupo6.repositories.IEspacioVerdeRepository;
import com.unla.grupo6.servicies.IEspacioVerdeService;

@Service("espacioVerdeService")
public class EspacioVerdeService implements IEspacioVerdeService {

	@Autowired
	@Qualifier("espacioVerdeRepository")
	private IEspacioVerdeRepository espacioVerdeRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<DisEspacioVerde> getAll() {
		return espacioVerdeRepository.findAll();
	}

	@Override
	public DisEspacioVerdeModel insertOrUpdate(DisEspacioVerdeModel disEspacioVerdeModel) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveVerde(DisEspacioVerde disEspacioVerde) {
		espacioVerdeRepository.save(disEspacioVerde);

	}

	@Override
	public DisEspacioVerde buscarVerde(long id) {
		return espacioVerdeRepository.findById(id).get();
	}

	@Override
	public void eliminarVerde(long id) {
		espacioVerdeRepository.deleteById(id);
		
	}

	@Override
	public DisEspacioVerde actualizarDisEspacioVerde(DisEspacioVerde disEspacioVerde) {
		return espacioVerdeRepository.save(disEspacioVerde);
	}



	
}
