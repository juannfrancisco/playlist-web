/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.playlist.modelo.Playlist;

/**
 * @author jmaldonado
 *
 */
@ManagedBean
@RequestScoped
public class VerPlaylistControlador {

	private Playlist playlist;
	private String mensaje;
	
	public VerPlaylistControlador() {
	}
	
	
	/**
	 * 
	 * @param playlist
	 * @return
	 */
	public String verPlaylist( Playlist playlist ){
		this.playlist = playlist;
		return "ver-playlist";
	}

	/**
	 * @return the playlist
	 */
	public Playlist getPlaylist() {
		return playlist;
	}

	/**
	 * @param playlist the playlist to set
	 */
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
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
