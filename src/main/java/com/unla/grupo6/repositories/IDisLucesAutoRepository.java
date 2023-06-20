package com.unla.grupo6.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo6.entities.DisLucesAuto;

@Repository("disLucesAutoRepository")
public interface IDisLucesAutoRepository extends JpaRepository<DisLucesAuto, Serializable> {

	public abstract DisLucesAuto findByNroAula(int nroAula);

	// public abstract DisLucesAuto findById(long id);

	public abstract List<DisLucesAuto> findByEstado(boolean estado);
	// @Query ("SELECT d FROM DisLucesAuto d where d.nroAula = (:nroAula)")

	public abstract Optional<DisLucesAuto> findByIdDispositivo(long id);
}
