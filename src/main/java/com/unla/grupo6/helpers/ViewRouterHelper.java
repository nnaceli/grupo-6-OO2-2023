package com.unla.grupo6.helpers;

public class ViewRouterHelper {
	/**** Views ****/
	
	//DISPOSITIVO
	public final static String DISPOSITIVO_INDEX =  "Dispositivo/index";
	
	
	//ESPACIO VERDE ver bien como hacerlas 
	public final static String ESPACIOVERDE_INDEX =  "DisEspacioVerde/index";
	public final static String ESPACIOVERDE_AGREGAR = "DisEspacioVerde/agregarEspacioVerde";
	public final static String ESPACIOVERDE_MODIFICAR = "DisEspacioVerde/modificarEspacioVerde";
	public final static String ESPACIOVERDE_ELIMINAR = "DisEspacioVerde/eliminarEspacioVerde";
	public final static String ESPACIOVERDE_AGREGADO = "DisEspacioVerde/espacioVerdeAgregado";
	public final static String ESPACIOVERDE_CARGAR = "DisEspacioVerde/cargarEspacioVerde";
	
	public final static String ESPACIOVERDE_ROUTE_INDEX = "/index";
	
	//ESTACIONAMIENTO
	public final static String ESTACIONAMIENTO_INDEX = "DisEstacionamiento/index";
	public final static String ESTACIONAMIENTO_ROUTE_INDEX = "DisEstacionamiento/";
	public final static String ESTACIONAMIENTO_PLAZAS_DISPONIBLES = "DisEstacionamiento/estacionamientosGeneral";
	
	public final static String ESTACIONAMIENTO_CARGAR = "DisEstacionamiento/cargarDispositivo";
	public final static String ESTACIONAMIENTO_AGREGAR = "DisEstacionamiento/agregarDispositivo";
	public final static String ESTACIONAMIENTO_AGREGADO = "DisEstacionamiento/dispositivoAgregado";
	public final static String ESTACIONAMIENTO_MODIFICAR = "DisEstacionamiento/modificarDispositivo";
	public final static String ESTACIONAMIENTO_ELIMINAR = "DisEstacionamiento/eliminarDispositivo";

	
	//BAÑOS
	public final static String BAÑO_INDEX = "baño/index";
	public final static String BAÑO_LISTA = "baño/lista";
	public final static String BAÑO_CREAR = "baño/crear";
	public final static String BAÑO_REDIRECT_LISTA = "redirect:/baño/lista";
	
	//LUCES
	public final static String LUCES_INDEX = "DisLucesAuto/index";
	public final static String LUCES_AGREGAR = "DisLucesAuto/agregarLuces";
	public final static String LUCES_MODIFICAR= "DisLucesAuto/modificarLuces";
	public final static String LUCES_ELIMINAR= "DisLucesAuto/eliminarLuces";
	public final static String LUCES_CAMBIAR_ESTADO= "DisLucesAuto/cambiarEstado";
	
	//USER
	public final static String USER_LOGIN = "User/login";
	public final static String USER_LOGOUT = "User/logout";
	
}
