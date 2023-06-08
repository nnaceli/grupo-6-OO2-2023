//package com.unla.grupo6.repositories;
//
//import java.io.Serializable;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.unla.grupo6.entities.Dispositivo;
//
//public interface IDispositivoRepository extends JpaRepository <Dispositivo, Serializable>{
//		
//		public abstract Dispositivo findById(int id);
//		
//		public abstract Dispositivo findByNombre(String nombre);
//		
//		public abstract Dispositivo findByDescripcion(String descripcion);
//		
//		public abstract Dispositivo findByFuncionamiento(boolean enFuncionamiento);
//		
//		//revisar que tipo de query hay que hacer para el tp 
//		//debo traer una lista?
//		@Query("SELECT d FROM Dispositivo d JOIN FETCH d.disEspacioVerde de WHERE de.nombre = (:nombre)")
//		public abstract Dispositivo findByEspacioVerdeNombre(String nombre);
//		
//		
//		
//}
