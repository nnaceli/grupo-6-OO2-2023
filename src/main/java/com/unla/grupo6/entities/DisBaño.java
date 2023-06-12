package com.unla.grupo6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="dis_baño")
public class DisBaño extends Dispositivo {
	
	@Column(name="habilitado")
	private boolean habilitado;
	
	@Column(name="personaLimpiando")
	private boolean personaLimpiando;
	
	@Column(name="sector")
	private String sector;


	public DisBaño(int id, String nombre, String descripcion, boolean enFuncionamiento, String sector) {
		super(id, nombre, descripcion, enFuncionamiento);
		this.habilitado= true;
		this.personaLimpiando = false;
		this.sector = sector;
	}
	
	/*
	public boolean verificarBaño() {
		if(personaLimpiando == true) {
			habilitado = false;
		}
		return habilitado;
	}
	
	public String informarEstado() {
		String informe;
		if(habilitado == true) {
			informe= "El baño se encuentra habilitado para su uso";
		}else {
			informe="El baño esta siendo higienizado por lo que se encuentra deshabilitado para su uso";
		}
		
		return informe;
		
	}
	*/

	
}
