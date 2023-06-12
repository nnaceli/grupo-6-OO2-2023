package com.unla.grupo6.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class DispositivoModel {	
	
	private int id;

	private String nombre;
	
	private String descripcion;
	
	private boolean enFuncionamiento;
	
	public DispositivoModel() {}

	//constructor
	public DispositivoModel(int id, String nombre, String descripcion, boolean enFuncionamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.enFuncionamiento = enFuncionamiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEnFuncionamiento() {
		return enFuncionamiento;
	}

	public void setEnFuncionamiento(boolean enFuncionamiento) {
		this.enFuncionamiento = enFuncionamiento;
	}
	
	
}
