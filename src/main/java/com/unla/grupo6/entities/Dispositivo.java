package com.unla.grupo6.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) //See more in https://www.baeldung.com/hibernate-inheritance
@DiscriminatorColumn(name = "tipo_dispositivo")
@Table(name="dispositivo")
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idDispositivo;
	
	@Column(name="nombre")
	@NotEmpty(message="el campo no debe estar vacio") 
	protected String nombre;
	
	@Column(name="descripcion")
	@NotEmpty(message="el campo no debe estar vacio") 
	protected String descripcion;
	
	@Column(name="enFuncionamiento")
	@NotNull(message = "El campo no debe ser nulo") 
	protected boolean enFuncionamiento;

	public Dispositivo(String nombre, String descripcion, boolean enFuncionamiento) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.enFuncionamiento = enFuncionamiento;
	}
	
	
	public Dispositivo(String nombre) {
		this.nombre = nombre;
	}
	
}
