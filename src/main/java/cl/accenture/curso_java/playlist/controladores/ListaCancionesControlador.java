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
import cl.accenture.curso_java.playlist.modelo.Cancion;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Login.
 *
 */
@ManagedBean
@RequestScoped
public class ListaCancionesControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private List<Cancion> canciones;
	private String mensaje;
	
	/**
	 * 
	 */
	public ListaCancionesControlador() {
		obtenerCanciones();
	}
	
	
	/**
	 * Obtiene todas las canciones de la base de datos
	 */
	public void obtenerCanciones(){
		try {
			this.canciones = CancionDAO.obtenerCanciones();
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las canciones";
			this.canciones = new ArrayList<Cancion>();
		}
	}
	
	/**
	 * Elimina una cancion determinada y luego obtiene todas las canciones 
	 * para refrescar la tabla.
	 * @param cancion
	 */
	public void eliminar(Cancion cancion){
		try {
			CancionDAO.eliminarCancion(cancion);
			obtenerCanciones();
			this.mensaje = "la cancion fue eliminada correctamente";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar la cancion";
		}
	}
	
	

	/**
	 * @return the canciones
	 */
	public List<Cancion> getCanciones() {
		return canciones;
	}

	/**
	 * @param canciones the canciones to set
	 */
	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
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

	
}
