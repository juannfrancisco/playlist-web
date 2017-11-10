/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;

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
public class NuevaPlaylistControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private String nombrePlaylist;
	private String descripcion;
	private String mensaje;
	
	/**
	 * 
	 */
	public NuevaPlaylistControlador() {
	}
	
	
	/**
	 * @return the nombrePlaylist
	 */
	public String getNombrePlaylist() {
		return nombrePlaylist;
	}

	/**
	 * @param nombrePlaylist the nombrePlaylist to set
	 */
	public void setNombrePlaylist(String nombrePlaylist) {
		this.nombrePlaylist = nombrePlaylist;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String agregarPlaylist(){
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		Playlist playlist = new Playlist();
		playlist.setNombre( this.nombrePlaylist );
		playlist.setDescripcion(this.descripcion);
		usuario.setNombreUsuario(usuario.getNombreUsuario());
		try {
			PlaylistDAO.agregarPlaylist(playlist, usuario);
			this.mensaje = "El playlist se agrego correctamente";
		} catch (Exception e) {
			this.mensaje = "Ocurrio un error al agregar la playlist";
		}
		return "";
	}

}