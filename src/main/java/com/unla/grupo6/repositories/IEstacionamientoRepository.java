package com.unla.grupo6.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.DisEstacionamiento;

@Repository("estacionamientoRepository")
public interface IEstacionamientoRepository extends JpaRepository<DisEstacionamiento, Serializable> {
	
	public abstract List<DisEstacionamiento> findBySector(String sector);

	public abstract List<DisEstacionamiento> findByEnFuncionamiento(boolean enFuncionamiento);
	
	public abstract List<DisEstacionamiento> findBySectorAndEnFuncionamiento(String sector, boolean enFuncionamiento);
	
	public abstract List<DisEstacionamiento> findBySectorAndTipoEstacionamiento(String sector, int tipoEstacionamiento);
	
	public abstract List<DisEstacionamiento> findBySectorAndEnFuncionamientoAndTipoEstacionamiento(String sector, boolean enFuncionamiento, int tipoPlaza);
	/*
	@Query("SELECT d FROM DisEstacionamiento d where d.sector = (:sector) AND d.ocupado = false")
	public abstract List<DisEstacionamiento> findBySectorLibres(String sector);
	*/
}
