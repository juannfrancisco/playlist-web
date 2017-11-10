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

import cl.accenture.curso_java.playlist.dao.PlaylistDAO;
import cl.accenture.curso_java.playlist.modelo.Playlist;
import cl.accenture.curso_java.playlist.modelo.Usuario;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Login.
 *
 */
@ManagedBean
@RequestScoped
public class ListaPlaylistControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private List<Playlist> playlists;
	private String mensaje;
	
	/**
	 * 
	 */
	public ListaPlaylistControlador() {
		obtenerPlaylists();
	}
	
	
	/**
	 * Obtiene todas las playlists de la base de datos segun 
	 * el usuario que esta logeado.
	 */
	public void obtenerPlaylists(){
		try {
			Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			this.playlists = PlaylistDAO.obtenerPlaylists(usuario.getNombreUsuario());
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las playlists";
			this.playlists = new ArrayList<Playlist>();
		}
	}
	
	/**
	 * Elimina una cancion determinada y luego obtiene todas las canciones 
	 * para refrescar la tabla.
	 * @param cancion
	 */
	public void eliminar(Playlist playlist){
		try {
			PlaylistDAO.eliminarPlaylist(playlist);
			obtenerPlaylists();
			this.mensaje = "la playlist fue eliminada correctamente";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar la playlist";
		}
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
