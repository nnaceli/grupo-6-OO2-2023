package com.unla.grupo6.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DispositivoModel {	
	
	private int id;

	private String nombre;
	
	private boolean enFuncionamiento;

	//constructor
	public DispositivoModel(int id, String nombre, boolean enFuncionamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.enFuncionamiento = enFuncionamiento;
	}




	
	
}
