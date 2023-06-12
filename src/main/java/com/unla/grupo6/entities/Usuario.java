package com.unla.grupo6.entities;



import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name="usuario", unique=true, nullable= false, length=45)
	private String usuario;
	
	@Column (name="contraseña",  nullable = false, length=60)
	private String contraseña;
	
	@Column (name = "activado")
	private boolean activado;
	
	@Column (name = "fechaCreacion")
	@CreationTimestamp
	private LocalDateTime fechavCreacion;
	
	@Column (name = "actualizarFecha")
	@CreationTimestamp
	private LocalDateTime actualizarFecha;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
	private Set<UsuarioAdministrador> usuarioAdministrador = new HashSet<UsuarioAdministrador>();

	//constructor vacio
	public Usuario() {
		super();
	}


	public Set<UsuarioAdministrador> getUsuarioAdministrador() {
		return usuarioAdministrador;
	}


	public void setUsuarioAdministrador(Set<UsuarioAdministrador> usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean isActivado() {
		return activado;
	}

	public void setActivado(boolean activado) {
		this.activado = activado;
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

	public Object isEnabled() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
