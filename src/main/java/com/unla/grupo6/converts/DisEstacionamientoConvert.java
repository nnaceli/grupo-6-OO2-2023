//package com.unla.grupo6.converts;
//
//import org.springframework.stereotype.Component;
//
//import com.unla.grupo6.entities.DisEstacionamiento;
//import com.unla.grupo6.models.DisEstacionamientoModel;
//
//@Component
//public class DisEstacionamientoConvert {
//	
//	public DisEstacionamientoModel etityToModel(DisEstacionamiento disEstacionamiento) {
//		return new DisEstacionamientoModel(
//				disEstacionamiento.getIdDispositivo(), 
//				disEstacionamiento.getNombre(), 
//				disEstacionamiento.getDescripcion(),
//				disEstacionamiento.isEnFuncionamiento(), 
//				disEstacionamiento.isOcupado(), 
//				disEstacionamiento.getSector(), 
//				disEstacionamiento.getTipoEstacionamiento()
//		);
//	}
//	
//	public DisEstacionamiento modelToEntity(DisEstacionamientoModel disEstacionamientoModel) {
//		return new DisEstacionamiento(
//				disEstacionamientoModel.getNombre(),
//				disEstacionamientoModel.getDescripcion(),
//				disEstacionamientoModel.isEnFuncionamiento(),
//				disEstacionamientoModel.isOcupado(),
//				disEstacionamientoModel.getSector(),
//				disEstacionamientoModel.getTipoEstacionamiento()
//		);
//	}
//}
