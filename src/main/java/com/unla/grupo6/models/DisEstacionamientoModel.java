
package com.unla.grupo6.models;

import com.unla.grupo6.entities.Dispositivo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class DisEstacionamientoModel /*extends DispositivoModel*/{
	
	private boolean ocupado;
	private String sector;
	private int tipoEstacionamiento;

	public DisEstacionamientoModel() {}
	
	public DisEstacionamientoModel(/*int id, String nombre, String descripcion, boolean enFuncionamiento,*/ String sector, int tipoEstacionamiento) {
		//super(id, nombre, descripcion, enFuncionamiento);
		this.ocupado = false;
		this.sector = sector;
		this.tipoEstacionamiento = tipoEstacionamiento;
	}
	
	public boolean verificarDisponibilidad() {
		return ocupado;
	}
	
	public int liberarPlaza() {
		ocupado = false;
		return 1;
	}
	
	public int ocuparPlaza() {
		ocupado = true;
		return 1;
	}
}
