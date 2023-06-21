package com.unla.grupo6.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.Dispositivo;
import com.unla.grupo6.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Long>{
	
	//obtener los eventos en fecha y hora particular
	List<Evento> findByfechaHoraBetween(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta);
	
	List<Evento> findByDispositivo(Dispositivo dispositivo);
	
	List<Evento> findByNombreDispositivo(String nombre);
}
