package com.unla.grupo6.helpers;

public class ViewRouterHelper {
	/**** Views ****/

	// DISPOSITIVO
	public final static String DISPOSITIVO_INDEX = "Dispositivo/index";

	// EVENTO
	public final static String EVENTO_LISTA = "evento/lista";

	// ESPACIO VERDE ver bien como hacerlas
	public final static String ESPACIOVERDE_INDEX = "DisEspacioVerde/index";
	public final static String ESPACIOVERDE_AGREGAR = "DisEspacioVerde/agregarEspacioVerde";
	public final static String ESPACIOVERDE_MODIFICAR = "DisEspacioVerde/modificarEspacioVerde";
	public final static String ESPACIOVERDE_ELIMINAR = "DisEspacioVerde/eliminarEspacioVerde";
	public final static String ESPACIOVERDE_AGREGADO = "DisEspacioVerde/espacioVerdeAgregado";
	public final static String ESPACIOVERDE_CARGAR = "DisEspacioVerde/cargarEspacioVerde";
	public final static String ESPACIOVERDE_CREAR = "DisEspacioVerde/crearVerde";
	public final static String ESPACIOVERDE_LISTA = "DisEspacioVerde/listaVerde";
	public final static String ESPACIOVERDE_REDIRECT_LISTA = "redirect:/espacioverde/listaverde";
	public final static String ESPACIOVERDE_VER_SENSOR = "DisEspacioVerde/verSensor";

	public final static String ESPACIOVERDE_ROUTE_INDEX = "/index";

	// ESTACIONAMIENTO
	public final static String ESTACIONAMIENTO_INDEX = "DisEstacionamiento/index";
	public final static String ESTACIONAMIENTO_LISTA = "DisEstacionamiento/lista_dispositivos";
	public final static String ESTACIONAMIENTO_REDIRECT_LISTA = "redirect:/estacionamientos/listaDispositivos";

	public final static String ESTACIONAMIENTO_CARGAR = "DisEstacionamiento/cargarDispositivo";
	public final static String ESTACIONAMIENTO_MODIFICAR = "DisEstacionamiento/modificarDispositivo";

	// BAÑOS
	public final static String BANIO_INDEX = "banio/index";
	public final static String BANIO_LISTA = "banio/lista";
	public final static String BANIO_CREAR = "banio/crear";
	public final static String BANIO_VER_CAMARA = "banio/verCamara";
	public final static String BANIO_REDIRECT_LISTA = "redirect:/banio/lista";

	// LUCES
	public final static String LUCES_INDEX = "DisLucesAuto/index";
	// public final static String LUCES_HOLA = "DisLucesAuto/helloworld";
	public final static String LUCES_AGREGAR = "DisLucesAuto/agregarLuces";
	public final static String LUCES_AGREGADAS = "DisLucesAuto/listaLucesAuto";
	public final static String LUCES_REDIRECT_AGREGADAS = "redirect:/lucesautomaticas/listaLucesAuto";
	public final static String LUCES_ELIMINAR = "DisLucesAuto/eliminarLuces";
	public final static String LUCES_VER_AULA = "DisLucesAuto/verAula";

	// USER
	public final static String USER_LOGIN = "User/login";
	public final static String USER_LOGOUT = "User/logout";

}
