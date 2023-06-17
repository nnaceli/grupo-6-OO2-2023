package com.unla.grupo6.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DisEspacioVerdeModel extends DispositivoModel {
	
	private boolean bajaHumedad;
	
	@Max(30)
	private float humedad;
	
	@Size(min=5, max=20)
	private String sector;
	
	//constructor
	public DisEspacioVerdeModel(int id, String nombre, String descripcion, boolean enFuncionamiento,
			boolean bajaHumedad, @Max(30) float humedad, @Size(min = 5, max = 20) String sector) {
		super(id, nombre, descripcion, enFuncionamiento);
		this.bajaHumedad = false;
		this.humedad = humedad;
		this.sector = sector;
	}

	
	//constructor vacio
	




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

	
	//METODOS
	public String regar (boolean bajaHumedad) {
		String riego;
		
		if(bajaHumedad == true) {
			 riego = "EMPAZAR A REGAR";
		}else {
			riego = "NO REGAR";
		}
		
		return riego;
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
