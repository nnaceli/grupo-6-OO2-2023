package com.unla.grupo6.models;

public class DisLucesAutoModel extends DispositivoModel {
	private boolean estado;

	// @Max(23)
	private int nroAula;

	public DisLucesAutoModel() {

	}

	public DisLucesAutoModel(int id, String nombre, String descripcion, boolean enFuncionamiento, boolean estado,
			int nroAula) {
		super(id, nombre, descripcion, enFuncionamiento);
		this.estado = estado;
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

//	public boolean verificarLuz(double cantLuz) {
//		boolean luz = false;
//		if (cantLuz > 40) {
//			cambiarEstado();
//		}
//		return luz;
//	}
//
//	public boolean cambiarEstado() {
//		this.setEstado(!isEstado());
//		return true;
//	}
}
