/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.playlist.dao.CancionDAO;
import cl.accenture.curso_java.playlist.dao.GeneroDAO;
import cl.accenture.curso_java.playlist.modelo.Cancion;
import cl.accenture.curso_java.playlist.modelo.Genero;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Login.
 *
 */
@ManagedBean
@RequestScoped
public class NuevaCancionControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private Cancion cancion;
	private String mensaje;
	private List<Genero> generos;
	
	/**
	 * 
	 */
	public NuevaCancionControlador() {
		this.cancion = new Cancion();
		obtenerGeneros();
	}
	
	/**
	 * @return the cancion
	 */
	public Cancion getCancion() {
		return cancion;
	}
	/**
	 * @param cancion the cancion to set
	 */
	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}
	
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the generos
	 */
	public List<Genero> getGeneros() {
		return generos;
	}

	/**
	 * @param generos the generos to set
	 */
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	/**
	 * 
	 * @return
	 */
	public void agregarCancion(){
		try {
			CancionDAO.agregarCancion(this.cancion);
			this.mensaje = "La cancion ha sido agregada correctamente";
			this.cancion = null;
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, ha ocurrido un error desconocido";
		}
	}
	
	/**
	 * Obtiene todas las canciones de la base de datos
	 */
	public void obtenerGeneros(){
		try {
			this.generos = GeneroDAO.obtenerGeneros();
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las generos musicales";
			this.generos = new ArrayList<Genero>();
		}
	}
	
	
}
