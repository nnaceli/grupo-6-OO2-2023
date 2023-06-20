package com.unla.grupo6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity

@Table(name = "dis_luces_auto")
public class DisLucesAuto extends Dispositivo {
	@Column(name = "estado")
	private boolean estado;

	@Column(name = "nroAula")
	private int nroAula;

	public DisLucesAuto(String nombre, boolean enFuncionamiento, boolean baja, boolean estado, int nroAula) {
		super(nombre, enFuncionamiento, baja);
		this.estado = estado;
		this.nroAula = nroAula;
	}

	public DisLucesAuto() {
		
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

}
