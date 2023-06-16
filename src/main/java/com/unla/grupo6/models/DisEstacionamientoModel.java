
package com.unla.grupo6.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import com.unla.grupo6.entities.Dispositivo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
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
	
	public DisEstacionamientoModel(int id, String nombre, String descripcion, boolean enFuncionamiento, boolean ocupado, String sector, int tipoEstacionamiento) {
		super(id, nombre, descripcion, enFuncionamiento);
		this.ocupado = ocupado;
		this.sector = sector;
		this.tipoEstacionamiento = tipoEstacionamiento;
	}
	
	public DisEstacionamientoModel() {
		// TODO Auto-generated constructor stub
	}

	public boolean verificarDisponibilidad() {
		return ocupado;
	}
}
