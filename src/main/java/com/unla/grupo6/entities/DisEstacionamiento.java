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

	public DisEstacionamiento(String nombre, boolean enFuncionamiento, boolean baja, boolean ocupado, String sector,
			int tipoEstacionamiento) {
		super(nombre, enFuncionamiento, baja);
		this.ocupado = ocupado;
		this.sector = sector;
		this.tipoEstacionamiento = tipoEstacionamiento;
	}

	@Override
	public String toString() {
		return "DisEstacionamiento [ocupado=" + ocupado + ", sector=" + sector + ", tipoEstacionamiento="
				+ tipoEstacionamiento + ", enFuncionamiento="+enFuncionamiento+"]";
	}
	
	
	
	
}