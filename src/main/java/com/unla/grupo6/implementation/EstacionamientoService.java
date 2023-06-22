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
public class EstacionamientoService implements IEstacionamientoService {

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

	public List<DisEstacionamiento> getPorSectorYtipo(String sector, int tipo) {
		return estacionamientoRepository.findBySectorAndTipoEstacionamiento(sector, tipo);
	}

	public List<DisEstacionamiento> getEnFuncionamiento() {
		return estacionamientoRepository.findByEnFuncionamiento(true);
	}

	@Override
	public List<DisEstacionamiento> getPorSectorYfuncionamiento(String sector, boolean enFuncionamiento) {
		return estacionamientoRepository.findBySectorAndEnFuncionamiento(sector, enFuncionamiento);
	}

	@Override
	public List<DisEstacionamiento> getPorSectorYfuncionamientoYtipo(String sector, boolean enFuncionamiento,
			int tipo) {
		return estacionamientoRepository.findBySectorAndEnFuncionamientoAndTipoEstacionamiento(sector, enFuncionamiento,
				tipo);
	}
	
	@Override
	public DisEstacionamiento insert(DisEstacionamiento objDisEstacionamiento) {
		// se establece el limite max de dispositivos segun el sector y el tipo de
		// estacionamiento
		int limiteDeCarga = establecerLimiteDeCarga(objDisEstacionamiento.getSector(),objDisEstacionamiento.getTipoEstacionamiento());
		List<DisEstacionamiento> listaDisEstacionamientosFiltrada = getPorSectorYtipo(objDisEstacionamiento.getSector(),objDisEstacionamiento.getTipoEstacionamiento());

		// si la cantidad de dispositivos cargados son menores al limite, se carga el
		// dispositivo
		
		if (listaDisEstacionamientosFiltrada.size() < limiteDeCarga) {
			estacionamientoRepository.save(objDisEstacionamiento);
		}
		
		return null;
	}

	@Override
	public DisEstacionamiento update(DisEstacionamiento objDisEstacionamiento) {
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

		List<DisEstacionamiento> listaDisEstacionamientoEnFuncionamiento = estacionamientoRepository
				.findByEnFuncionamiento(true);
		DisEstacionamiento dispositivoAactualizar;
		double cambioDeDisponibilidad;
		int idDispositivoAmodificar;
		int cantDispositivosEnFuncionamiento = listaDisEstacionamientoEnFuncionamiento.size();

		for (int i = 0; i < 20; i++) {

			cambioDeDisponibilidad = Math.random() * 100;
			idDispositivoAmodificar = (int) (Math.random() * (0 + (cantDispositivosEnFuncionamiento - 1)));
			dispositivoAactualizar = listaDisEstacionamientoEnFuncionamiento.get(idDispositivoAmodificar);

			if (cambioDeDisponibilidad > 50)
				dispositivoAactualizar.setOcupado(!dispositivoAactualizar.isOcupado());

			estacionamientoRepository.save(dispositivoAactualizar);
		}

	}

	private int establecerLimiteDeCarga(String sector, int tipoEstacionamiento) {

		int limiteCarga = 30;
		
		if (sector.compareTo("Buffet") == 0 || sector.compareTo("29 de Septiembre") == 0 ) {

			limiteCarga = 14;

			if (tipoEstacionamiento == 2)
				limiteCarga = 10;

		} else if (sector.compareTo("Pablo Nogues") == 0  || sector.compareTo("José Malba") == 0) {

			limiteCarga = 12;

			if (tipoEstacionamiento == 2)
				limiteCarga = 5;
		}
		
		return limiteCarga;
	}

}
