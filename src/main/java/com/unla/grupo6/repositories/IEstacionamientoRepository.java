package com.unla.grupo6.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.DisEstacionamiento;

@Repository("estacionamientoRepository")
public interface IEstacionamientoRepository extends JpaRepository<DisEstacionamiento, Serializable> {
	
	//public abstract DisEstacionamiento findById(int id);
	
	public abstract List<DisEstacionamiento> findBySector(String sector);
	
}
