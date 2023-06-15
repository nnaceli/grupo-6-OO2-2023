package com.unla.grupo6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dis_luces_auto")
public class DisLucesAuto extends Dispositivo {
	@Column(name = "estado")
	private boolean estado;

	@Column(name = "nroAula")
	private int nroAula;

	public DisLucesAuto(int id, String nombre, String descripcion, boolean enFuncionamiento, int nroAula) {
		super(id, nombre, descripcion, enFuncionamiento);
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

}
