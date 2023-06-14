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
	
	private float humedad;
	
	private String sector;
	
	
	//constructor
	public DisEspacioVerde(int id, String nombre, String descripcion, boolean enFuncionamiento, boolean bajaHumedad,
			float humedad, String sector) {
		super(id, nombre, descripcion, enFuncionamiento);
		this.bajaHumedad = false;
		this.humedad = humedad;
		this.sector = sector;
	}




	// falta el o los metodos
	public String regar (boolean bajaHumedad) {
		String riego;
		
		if(bajaHumedad == true) {
			 riego = "EMPAZAR A REGAR";
		}else {
			riego = "NO REGAR";
		}
		
		return riego;
	}


	//getters y setters
	public boolean isBajaHumedad() {
		return bajaHumedad;
	}


	public void setBajaHumedad(boolean bajaHumedad) {
		this.bajaHumedad = bajaHumedad;
	}


	public float getHumedad() {
		return humedad;
	}


	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}
	
	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}

	
//	public int verificarHumedad() {
//
//        if(humedad < 30)
//            encenderRiego();
//
//        return 1;
//    }
//
//
//    public void encenderRiego() {
//        regar = true; 
//    }
}
