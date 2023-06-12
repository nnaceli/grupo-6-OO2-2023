/*package com.unla.grupo6.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class DisLucesAuto extends Dispositivo {
	private boolean estado;
	private int nroAula;

	public DisLucesAuto(int id, String nombre, String descripcion, boolean enFuncionamiento, boolean estado,
			int nroAula) {
		super(id, nombre, descripcion, enFuncionamiento);
		this.estado = estado;
		this.nroAula = nroAula;
	}

	public boolean verificarLuz() {
		boolean luz = false;
		if (this.estado == true) {
			// esto esta mal tengo que pensarlo aiuda
		}
		return luz;
	}

	// ver con brandon
	public boolean cambiarEstado() {
		boolean estado = false;
		if (this.estado == true) {
			estado = true;
		}
		this.setEstado(estado);
		return true;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getNroAula() {
		return nroAula;
	}

	public void setNroAula(int nroAula) {
		this.nroAula = nroAula;
	}

}*/
