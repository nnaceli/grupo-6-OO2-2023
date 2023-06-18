package com.unla.grupo6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
@DiscriminatorColumn(name = "estacionamiento")
@Table(name="dis_estacionamiento")
public class DisEstacionamiento extends Dispositivo{
	
	@Column(name="ocupado")
	private boolean ocupado;
	
	@Column(name="sector")
	private String sector;
	
	@Column(name="tipoEstacionamiento")
	private int tipoEstacionamiento;
	
	public DisEstacionamiento(String nombre, String descripcion, boolean enFuncionamiento, boolean ocupado, String sector, int tipoEstacionamiento) {
		super(nombre, descripcion, enFuncionamiento);
		this.ocupado = ocupado;
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