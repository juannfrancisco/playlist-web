/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.playlist.dao.PerfilDAO;
import cl.accenture.curso_java.playlist.modelo.Perfil;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Lista Usuarios.
 *
 */
@ManagedBean
@RequestScoped
public class ListaPerfilesControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private static final Logger LOGGER = Logger.getLogger(ListaPerfilesControlador.class);
	private List<Perfil> perfiles;
	private String mensaje;
	
	/**
	 * 
	 */
	public ListaPerfilesControlador() {
		obtenerPerfiles();
	}
	
	
	/**
	 * Obtiene todas las canciones de la base de datos
	 */
	public void obtenerPerfiles(){
		try {
			this.setPerfiles(PerfilDAO.obtenerPerfiles());
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener los perfiles";
			this.setPerfiles(new ArrayList<Perfil>());
			LOGGER.error("Ocurrio un error ", e);
		}
	}
	
	
	
	/**
	 * Elimina una cancion determinada y luego obtiene todas las canciones 
	 * para refrescar la tabla.
	 * @param cancion
	 */
	public void eliminar(Perfil perfil){
		try {
//			UsuarioDAO.eliminarUsuario(usuario);
			obtenerPerfiles();
			this.mensaje = "el perfil fue eliminado correctamente";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar el perfil";
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
	 * @return the perfiles
	 */
	public List<Perfil> getPerfiles() {
		return perfiles;
	}


	/**
	 * @param perfiles the perfiles to set
	 */
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}





}
