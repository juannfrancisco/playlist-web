/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.util.Collections;
import java.util.Comparator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.playlist.dao.PlaylistDAO;
import cl.accenture.curso_java.playlist.modelo.Cancion;
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
		try {
			this.playlist.setCanciones( PlaylistDAO.obtenerCanciones(playlist) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ver-playlist";
	}
	
	
	/**
	 * 
	 */
	public void ordenarPorNombre(){
		Collections.sort( this.playlist.getCanciones(), new Comparator<Cancion>() {
			@Override
			public int compare(Cancion arg0, Cancion arg1) {
				return arg0.getNombre().toLowerCase().compareTo( arg1.getNombre().toLowerCase() );
			}
		} );
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
