
package com.unla.grupo6.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.Dispositivo;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository <Dispositivo, Serializable>{
		
		public abstract Dispositivo findByIdDispositivo(int idDispositivo);
		
		public abstract Dispositivo findByNombre(String nombre);
		
		
		public abstract Dispositivo findByEnFuncionamiento(boolean enFuncionamiento);
		
		//revisar que tipo de query hay que hacer para el tp 
		//debo traer una lista?
		@Query("SELECT d FROM Dispositivo d where d.nombre = (:nombre)")
		//public abstract Dispositivo findByEspacioVerdeNombre(String nombre);
		public abstract List<Dispositivo> findByDispositivoName (String nombre);
		
		
		
}

//MUY RARO ESTO DEBO REVISARLO