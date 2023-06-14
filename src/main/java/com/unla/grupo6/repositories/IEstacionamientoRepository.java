package com.unla.grupo6.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo6.entities.DisEstacionamiento;

public interface IEstacionamientoRepository extends JpaRepository<DisEstacionamiento, Serializable> {

}
