package com.unla.grupo6.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//ESTO LO HICIMOS EN GRUPO

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "fechaHora")
	private LocalDateTime fechaHora;

	@Column(name = "nombreDispositivo")
	private String nombreDispositivo;

//	@ManyToOne (fetch=FetchType.LAZY, mappedBy="evento")
//	private Dispositivo dispositivo = new Dispositivo();

	@ManyToOne
	@JoinColumn(name = "idDispositivo", nullable = false)
	// @Column(name="dispositivo")
	private Dispositivo dispositivo;
	// private Dispositivo dispositivo;

	// constructor
	public Evento(Long id, LocalDateTime fechaHora, Dispositivo dispositivo) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.dispositivo = dispositivo;
	}

	// constructor sin ID asi aparece en la tfi
	public Evento(Dispositivo dispositivo, LocalDateTime fechaHora, String nombre) {
		super();
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
		this.nombreDispositivo = nombre;
	}

}
