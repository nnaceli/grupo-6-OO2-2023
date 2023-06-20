package com.unla.grupo6.implementation;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.DisLucesAuto;
import com.unla.grupo6.models.DisLucesAutoModel;
import com.unla.grupo6.repositories.IDisLucesAutoRepository;
import com.unla.grupo6.servicies.ILucesAutoService;

@Service("lucesAutoService")
public class DisLucesAutoService implements ILucesAutoService {

	@Autowired
	@Qualifier("disLucesAutoRepository")
	private IDisLucesAutoRepository lucesAutoRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<DisLucesAuto> getAll() {
		return lucesAutoRepository.findAll();
	}

	@Override
	public DisLucesAutoModel insertOrUpdate(DisLucesAutoModel objDisLucesAuto) {
		DisLucesAuto disLucesAuto = lucesAutoRepository.save(modelMapper.map(objDisLucesAuto, DisLucesAuto.class));
		return modelMapper.map(disLucesAuto, DisLucesAutoModel.class);
	}

	@Override
	public void save(DisLucesAuto disLucesAuto) {
		// TODO Auto-generated method stub
		lucesAutoRepository.save(disLucesAuto);
	}

	// revisar
	@Override
	public boolean remove(long id) {
	    Optional<DisLucesAuto> optionalLucesAuto = lucesAutoRepository.findById(id);
	    if (optionalLucesAuto.isPresent()) {
	        DisLucesAuto lucesAuto = optionalLucesAuto.get();
	        lucesAuto.setBaja(true);
	        lucesAutoRepository.delete(lucesAuto);
	        return true;
	    }
	    return false;
	}

	@Override
	public DisLucesAuto buscar(long id) {
		// TODO Auto-generated method stub
		return lucesAutoRepository.findById(id).orElse(null);
	}

}
