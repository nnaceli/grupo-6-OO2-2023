package com.unla.grupo6.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	protected String nombre;
	
	protected String descripcion;
	
	protected boolean enFuncionamiento;

	public Dispositivo(int id, String nombre, String descripcion, boolean enFuncionamiento) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.enFuncionamiento = enFuncionamiento;
	}
	
	
}
