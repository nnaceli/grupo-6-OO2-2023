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

	//constructor
	public DisEspacioVerde(String nombre, boolean enFuncionamiento, boolean bajaHumedad,
			float humedad, String sector) {
		super(nombre, enFuncionamiento);
		this.bajaHumedad = bajaHumedad;
		this.humedad = humedad;
		this.sector = sector;
	}
	
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
	
	
//7NO PODRIA HACER UN SET DE BAJA HUMEDAD CON UN IF DEL VALOR HUMEDAD QUE LA CAMBIE DE TRUE A FALSE DEPENDIENDO EL VALOR? PARA PENSAR
	
	//OTRA OPCION ESTE METODO AUNQUE NO SE DONDE APLICARLO PARA PENSAR
	//NO FUNCIONA ESTE METODO
//	public boolean estadoHumedad () {
//		if(this.humedad >= 60) {
//			this.bajaHumedad=false;
//		}else {
//			this.bajaHumedad=true;
//		}
//		
//		return this.bajaHumedad;
//	}




//	// falta el o los metodos
//	public String regar (boolean bajaHumedad) {
//		String riego;
//		
//		if(bajaHumedad == true) {
//			 riego = "EMPAZAR A REGAR";
//		}else {
//			riego = "NO REGAR";
//		}
//		
//		return riego;
//	}
//
//

	
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
