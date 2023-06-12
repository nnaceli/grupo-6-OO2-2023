package com.unla.grupo6.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//ESTO LO HICIMOS EN GRUPO

@Entity
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="fechaHora")
	private LocalDateTime fechaHora;
	
	public Evento() {}
	
//	@ManyToOne (fetch=FetchType.LAZY, mappedBy="evento")
//	private Dispositivo dispositivo = new Dispositivo();
	
	@ManyToOne
	@JoinColumn(name = "idDispositivo")
	//@Column(name="dispositivo")
	private Dispositivo dispositivo;
	//private Dispositivo dispositivo;

	//constructor
	public Evento(int id, Dispositivo dispositivo, LocalDateTime fechaHora) {
		super();
		this.id = id;
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
	}

	//constructor sin ID asi aparece en la tfi
	public Evento(Dispositivo dispositivo, LocalDateTime fechaHora) {
		super();
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
	}

	//METODOS ACCESORES
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	
	
	
	
}
