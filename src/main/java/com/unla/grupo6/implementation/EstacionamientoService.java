package com.unla.grupo6.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//import com.unla.grupo6.converts.DisEstacionamientoConvert;
import com.unla.grupo6.entities.DisEstacionamiento;
import com.unla.grupo6.repositories.IEstacionamientoRepository;
import com.unla.grupo6.servicies.IEstacionamientoService;

@Service("estacionamientoService")
public class EstacionamientoService implements IEstacionamientoService{

	@Autowired
	@Qualifier("estacionamientoRepository")
	private IEstacionamientoRepository estacionamientoRepository;
	
//	@Autowired
//	@Qualifier("disEstacionamientoConvert")
//	private DisEstacionamientoConvert disEstacionamientoConvert;
	

	
	@Override
	public List<DisEstacionamiento> getAll() {
		return estacionamientoRepository.findAll();
	}
	
	@Override
	public List<DisEstacionamiento> getPorSector(String sector) {
		return estacionamientoRepository.findBySector(sector);
	}
	
	public List<DisEstacionamiento> getPorSectorYtipo(String sector, int tipo){
		return estacionamientoRepository.findBySectorAndTipoEstacionamiento(sector, tipo);
	}
	
	public List<DisEstacionamiento> getEnFuncionamiento(){
		return estacionamientoRepository.findByEnFuncionamiento(true);
	}
	
	@Override
	public List<DisEstacionamiento> getPorSectorYfuncionamiento(String sector, boolean enFuncionamiento) {
		return estacionamientoRepository.findBySectorAndEnFuncionamiento(sector, enFuncionamiento);
	}
	
	@Override
	public List<DisEstacionamiento> getPorSectorYfuncionamientoYtipo(String sector, boolean enFuncionamiento, int tipo) {
		return estacionamientoRepository.findBySectorAndEnFuncionamientoAndTipoEstacionamiento(sector, enFuncionamiento, tipo);
	}
	
	@Override
	public DisEstacionamiento insertOrUpdate(DisEstacionamiento objDisEstacionamiento) { 
		
		int limiteDeCarga;
		
		return estacionamientoRepository.save(objDisEstacionamiento);
	}

	@Override
	public DisEstacionamiento obtenerEstacionamiento(Long id) {
		return estacionamientoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarEstacionamiento(Long id) {
		estacionamientoRepository.deleteById(id);
	}
	
	@Override
	public void actualizarDisponibilidadEstacionamientos() {
		
		List<DisEstacionamiento> listaDisEstacionamientoEnFuncionamiento = estacionamientoRepository.findByEnFuncionamiento(true);
		DisEstacionamiento dispositivoAactualizar;
		double cambioDeDisponibilidad;
		int idDispositivoAmodificar;
		int cantDispositivosEnFuncionamiento = listaDisEstacionamientoEnFuncionamiento.size();
		
		for(int i=0; i<20; i++) {
			
			cambioDeDisponibilidad = Math.random()*100;
			idDispositivoAmodificar = (int) (Math.random() * (0 + (cantDispositivosEnFuncionamiento-1)));
			dispositivoAactualizar = listaDisEstacionamientoEnFuncionamiento.get(idDispositivoAmodificar);
			
			if(cambioDeDisponibilidad > 50)
				dispositivoAactualizar.setOcupado(!dispositivoAactualizar.isOcupado());
			
			estacionamientoRepository.save(dispositivoAactualizar);
		}
		
	}
	
	private int establecerLimiteDeCarga(String sector, int tipoEstacionamiento) {
		
		int limiteCarga = 20;
		
		if(sector == "Buffet" || sector == "29 de Septiembre") {
			
			limiteCarga = 50;
			
			if(tipoEstacionamiento == 2)
				limiteCarga = 10;
			
		}else if(tipoEstacionamiento == 2){
			
			limiteCarga = 5;
		}
		
		return limiteCarga;
	}
	
}
