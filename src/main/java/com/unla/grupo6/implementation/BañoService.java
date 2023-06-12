package com.unla.grupo6.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo6.repositories.IBañoRepository;
import com.unla.grupo6.servicies.IBañoService;


@Service("bañoService")
public class BañoService implements IBañoService{
	
	@Autowired
	@Qualifier("bañoRepository")
	private IBañoRepository bañoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
}
