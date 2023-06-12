//package com.unla.grupo6.repositories;
//
//import java.io.Serializable;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.unla.grupo6.entities.Usuario;
//
//@Repository("usuarioRepository")
//public interface IUsuarioRepository extends JpaRepository <Usuario, Serializable> {
//	
//	@Query("SELECT u FROM Usuario u JOIN FETCH u.userAdministrador where u.usuario = (:usuario)")
//	public abstract Usuario findByUsuarioAndFetchUsuarioAdministradorEagerly(@Param("usuario") String usuarioNombre);
//	
//	
//}
