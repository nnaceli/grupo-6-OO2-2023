package com.unla.grupo6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class DisEspacioVerde extends Dispositivo {

	private boolean bajaHumedad;

	public DisEspacioVerde(int id, String nombre, String descripcion, boolean enFuncionamiento) {
		super(id, nombre, descripcion, enFuncionamiento);
		// TODO Auto-generated constructor stub
	}

	// falta el o los metodos
}
