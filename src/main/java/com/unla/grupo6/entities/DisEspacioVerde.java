package com.unla.grupo6.entities;



import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("espacioVerde")
@Table(name="dis_espacio_verde")
public class DisEspacioVerde extends Dispositivo {

	
	
	@Column(name="bajaHumedad")
	private boolean bajaHumedad;


	@Column(name="humedad")
	@NotNull(message = "El campo no debe ser nulo")
	private float humedad;
	
	@Column(name="sector")
	@NotNull(message = "El campo no debe estar vacio")
	private String sector;
	
	@Column(name="regando")
	private String regando;

	public DisEspacioVerde(String nombre, boolean enFuncionamiento, boolean baja, boolean bajaHumedad, float humedad,String sector, String regando) {
		super(nombre, enFuncionamiento, baja);
		this.bajaHumedad = bajaHumedad;
		this.humedad = humedad;
		this.sector = sector;
		this.regando = regando;
	}
	
}
