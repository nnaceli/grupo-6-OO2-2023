package com.unla.grupo6.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.DisBaño;


@Repository("bañoRepository")
public interface IBañoRepository extends JpaRepository<DisBaño, Serializable> {

}
