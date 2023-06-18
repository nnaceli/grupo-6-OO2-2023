package com.unla.grupo6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "dis_luces_auto")
public class DisLucesAuto extends Dispositivo {
	@Column(name = "estado")
	private boolean estado;

	@Column(name = "nroAula")
	private int nroAula;

	public DisLucesAuto(String nombre, boolean enFuncionamiento, int nroAula) {
		super(nombre, enFuncionamiento);
		this.estado = false;
		this.nroAula = nroAula;
	}

	public DisLucesAuto() {
		super(null);
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
