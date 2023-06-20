package com.unla.grupo6.servicies;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.unla.grupo6.entities.DisEstacionamiento;

public interface IEstacionamientoService {
	
	public List<DisEstacionamiento> getAll();
	
	public List<DisEstacionamiento> getPorSector(String sector);
	
	public List<DisEstacionamiento> getPorSectorYfuncionamiento(String sector, boolean enFuncionamiento);
	
	public List<DisEstacionamiento> getPorSectorYfuncionamientoYtipo(String sector, boolean enFuncionamiento, int tipo);
	
	public DisEstacionamiento insertOrUpdate(DisEstacionamiento objDisEstacionamiento);
	
	public DisEstacionamiento obtenerEstacionamiento(Long id);
	
	public void eliminarEstacionamiento(Long id);
	
}
