package com.unla.grupo6.entities;



import jakarta.persistence.Column;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	protected Long idDispositivo;
	
	@Column(name="nombre")
	@NotEmpty(message="el campo no debe estar vacio") 
	protected String nombre;
	
	@Column(name="enFuncionamiento", nullable = false)
	protected boolean enFuncionamiento;
	
	@Column(name="baja", nullable = false )
	protected boolean baja;

	public Dispositivo(String nombre, boolean enFuncionamiento, boolean baja) {
		this.nombre = nombre;
		this.enFuncionamiento = enFuncionamiento;
		this.baja = false;
	}
	
	
	

}
