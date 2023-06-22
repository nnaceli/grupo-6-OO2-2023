package com.unla.grupo6.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.unla.grupo6.entities.DisBaño;
import com.unla.grupo6.entities.Evento;


@Repository("bañoRepository")
public interface IBañoRepository extends JpaRepository<DisBaño, Serializable> {
	
	

}
