/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.playlist.dao.UsuarioDAO;
import cl.accenture.curso_java.playlist.modelo.Usuario;
import cl.accenture.curso_java.playlist.servicios.ServicioEncriptar;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Login.
 *
 */
@ManagedBean
@RequestScoped
public class NuevoUsuarioControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private Usuario usuario;
	private String confirmarPassword;
	private String mensaje;
	
	/**
	 * 
	 */
	public NuevoUsuarioControlador() {
		this.setUsuario(new Usuario());
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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the confirmarPassword
	 */
	public String getConfirmarPassword() {
		return confirmarPassword;
	}


	/**
	 * @param confirmarPassword the confirmarPassword to set
	 */
	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}


	/**
	 * 
	 */
	public void agregarUsuario(){
		try {
			this.usuario.setPassword( ServicioEncriptar.encriptar(this.usuario.getPassword()) );
			UsuarioDAO.agregarUsuario(this.usuario);
			this.mensaje = "El usuario ha sido agregada correctamente";
			this.usuario = null;
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, ha ocurrido un error desconocido";
		}
	}
}
