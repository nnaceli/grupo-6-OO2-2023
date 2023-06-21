package com.unla.grupo6.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Long>{
	
	//obtener los eventos en fecha y hora particular
	List<Evento> findByfechaHora(LocalDateTime fechaHora);
	
	@Query("SELECT e FROM Evento e WHERE e.dispositivo.nombre LIKE %?1%")
	public List<Evento> getAll(String palabraClave);
}
