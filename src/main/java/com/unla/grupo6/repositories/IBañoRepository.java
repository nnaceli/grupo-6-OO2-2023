package com.unla.grupo6.repositories;

import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.Evento;


@Repository("bañoRepository")
public interface IBañoRepository extends JpaRepository<DisBaño, Serializable> {
	
	boolean existsByNombreAndSector(String nombre, String sector);
	
	@Query("SELECT d FROM DisBaño d WHERE d.nombre = (:nombre)")
	public abstract DisBaño getByUsername(@Param("nombre") String nombre);
	

}
