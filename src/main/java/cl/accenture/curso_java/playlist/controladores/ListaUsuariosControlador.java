/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.playlist.dao.UsuarioDAO;
import cl.accenture.curso_java.playlist.modelo.Usuario;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Lista Usuarios.
 *
 */
@ManagedBean
@RequestScoped
public class ListaUsuariosControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private List<Usuario> usuarios;
	private String mensaje;
	
	/**
	 * 
	 */
	public ListaUsuariosControlador() {
		obtenerUsuarios();
	}
	
	
	/**
	 * Obtiene todas las canciones de la base de datos
	 */
	public void obtenerUsuarios(){
		try {
			this.setUsuarios(UsuarioDAO.obtenerUsuarios());
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las canciones";
			this.setUsuarios(new ArrayList<Usuario>());
		}
	}
	
	
	
	/**
	 * Elimina una cancion determinada y luego obtiene todas las canciones 
	 * para refrescar la tabla.
	 * @param cancion
	 */
	public void eliminar(Usuario usuario){
		try {
			UsuarioDAO.eliminarUsuario(usuario);
			obtenerUsuarios();
			this.mensaje = "el usuario fue eliminado correctamente";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar el usuario";
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
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



}
