package com.unla.grupo6.models;

import java.time.LocalTime;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class DisLucesAutoModel extends DispositivoModel {
	private boolean estado;

	// @Max(23)
	private int nroAula;
	
	public DisLucesAutoModel(int id, String nombre, boolean enFuncionamiento, int nroAula) {
		super(id, nombre, enFuncionamiento);
		this.estado = false;
		this.nroAula = nroAula;
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

	public int verificarLuz(LocalTime hora) {
		if (hora.isAfter(LocalTime.of(17, 55)) || hora.isAfter(LocalTime.of(7, 0))) {
			cambiarEstado();
		}
		return 1;
	}

	public boolean cambiarEstado() {
		this.setEstado(!isEstado());
		return true;
	}
}
