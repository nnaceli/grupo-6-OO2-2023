package com.unla.grupo6.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DispositivoModel {	
	
	private int id;

	private String nombre;
	
	private String descripcion;
	
	private boolean enFuncionamiento;

	//constructor
	public DispositivoModel(int id, String nombre, String descripcion, boolean enFuncionamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.enFuncionamiento = enFuncionamiento;
	}
	
}
