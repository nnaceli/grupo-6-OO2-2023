
package com.unla.grupo6.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DisEstacionamientoModel extends DispositivoModel{
	
	private boolean ocupado;
	
	//@Size(min=4, max=18)
	private String sector;
	
	//@Size(min=1, max=2)
	private int tipoEstacionamiento;
	
	public DisEstacionamientoModel(int id, String nombre, boolean enFuncionamiento, boolean ocupado, String sector, int tipoEstacionamiento) {
		super(id, nombre, enFuncionamiento);
		this.ocupado = ocupado;
		this.sector = sector;
		this.tipoEstacionamiento = tipoEstacionamiento;
	}


	public boolean verificarDisponibilidad() {
		return ocupado;
	}
}
