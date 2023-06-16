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
	
	public DisBaño(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Column(name="habilitado")
	private boolean habilitado;
	
	@Column(name="higienizandose")
	private boolean higienizandose;
	
	@Column(name="sector")
	private String sector;
	
	
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
