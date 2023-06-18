package com.unla.grupo6.entities;



import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@DiscriminatorValue("baño")
@Table(name="dis_baño")
public class DisBaño extends Dispositivo {
	
	@Column(name="habilitado")
	private boolean habilitado;
	
	@Column(name="higienizandose")
	private boolean higienizandose;
	
	@Column(name="sector")
	@NotEmpty(message="el campo no debe estar vacio")
	private String sector;
	
	public DisBaño(String nombre, String descripcion, boolean enFuncionamiento, boolean habilitado,
			boolean higienizandose, String sector) {
		super(nombre, descripcion, enFuncionamiento);
		this.habilitado = habilitado;
		this.higienizandose = higienizandose;
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
