package com.unla.grupo6.repositories;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.User;



@Repository("userRepository")
public interface IUserRepository extends JpaRepository <User, Serializable> {
	
	@Query("SELECT u FROM User u JOIN FETCH u.userRoles where u.username = (:username)")
	public abstract User findByUsernameAndFetchUserAdministradoresEagerly(@Param("username") String username);
	
	
}