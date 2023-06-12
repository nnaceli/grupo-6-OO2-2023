package com.unla.grupo6.repositories;
import com.unla.grupo6.entities.DisEspacioVerde;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface IEspacioVerdeRepository extends JpaRepository<DisEspacioVerde, Serializable> {
	
	public abstract DisEspacioVerde findBybajaHumedad (boolean bajaHumedad);
	
	public abstract DisEspacioVerde findByHumedad (float humedad);
	
	public abstract DisEspacioVerde findBySector (String sector);
	
	@Query ("SELECT v FROM DisEspacioVerde v where v.humedad = (:humedad)")
	public abstract List<DisEspacioVerde> findByHume (float humedad);
}
