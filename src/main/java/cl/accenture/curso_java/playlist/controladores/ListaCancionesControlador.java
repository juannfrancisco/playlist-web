/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.playlist.dao.CancionDAO;
import cl.accenture.curso_java.playlist.dao.PlaylistDAO;
import cl.accenture.curso_java.playlist.modelo.Cancion;
import cl.accenture.curso_java.playlist.modelo.Playlist;
import cl.accenture.curso_java.playlist.modelo.Usuario;

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
	private List<Playlist> playlists;
	private String mensaje;
	
	/**
	 * 
	 */
	public ListaCancionesControlador() {
		obtenerCanciones();
		obtenerPlaylists();
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
	 * Obtiene todas las playlists de la base de datos segun 
	 * el usuario que esta logeado.
	 */
	public void obtenerPlaylists(){
		try {
			Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			this.setPlaylists(PlaylistDAO.obtenerPlaylists(usuario.getNombreUsuario()));
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las playlists";
			this.setPlaylists(new ArrayList<Playlist>());
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
	 * 
	 * @param playlist
	 * @param cancion
	 */
	public void agregarCancion( Playlist playlist, Cancion cancion ){
		try {
//			CancionDAO.agregarCancion(cancion);
			PlaylistDAO.agregarCancion(playlist, cancion);
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


	/**
	 * @return the playlists
	 */
	public List<Playlist> getPlaylists() {
		return playlists;
	}


	/**
	 * @param playlists the playlists to set
	 */
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
}
