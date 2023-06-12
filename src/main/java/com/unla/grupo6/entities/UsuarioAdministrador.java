package com.unla.grupo6.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table (name = "usuario_admninistrador", uniqueConstraints=@UniqueConstraint(columnNames= {"role", "usuario_id"}))
public class UsuarioAdministrador {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id", nullable=false)
	private Usuario usuario;
	
	@Column (name="role", nullable=false, length=100)
	private String role;
	
	@Column (name = "fechaCreacion")
	@CreationTimestamp
	private LocalDateTime fechavCreacion;
	
	@Column (name = "actualizarFecha")
	@CreationTimestamp
	private LocalDateTime actualizarFecha;

	//constructor vacio
	public UsuarioAdministrador() {
		super();
	}

	//constructor
	public UsuarioAdministrador(int id, Usuario usuario, String role) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.role = role;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getFechavCreacion() {
		return fechavCreacion;
	}

	public void setFechavCreacion(LocalDateTime fechavCreacion) {
		this.fechavCreacion = fechavCreacion;
	}

	public LocalDateTime getActualizarFecha() {
		return actualizarFecha;
	}

	public void setActualizarFecha(LocalDateTime actualizarFecha) {
		this.actualizarFecha = actualizarFecha;
	}
	
	
	
}
