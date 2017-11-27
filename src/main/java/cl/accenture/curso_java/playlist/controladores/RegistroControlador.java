/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.playlist.dao.UsuarioDAO;
import cl.accenture.curso_java.playlist.modelo.Perfil;
import cl.accenture.curso_java.playlist.modelo.Usuario;
import cl.accenture.curso_java.playlist.servicios.ServicioEncriptar;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Login.
 *
 */
@ManagedBean
@SessionScoped
public class RegistroControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private static final Logger LOGGER = Logger.getLogger(RegistroControlador.class);

	private String nombreUsuario;
	private String password;
	private String rePassword;
	private String mensaje;
	private boolean error;
	
	
	public RegistroControlador() {
		this.nombreUsuario = "";
		this.password = "";
		this.mensaje = "";
	}
	
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 */
	public String registrar(){
		try {
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario(this.getNombreUsuario());
			usuario.setPassword( ServicioEncriptar.encriptar(this.password) );
			usuario.setPerfil( new Perfil( 2 ) );
			UsuarioDAO.agregarUsuario(usuario);
			return "login?faces-redirect=true";
		}  catch (Exception e) {
			LOGGER.error("Error desconocido", e);
			this.error = true;
			this.mensaje = "Ocurrio un error inesperado, intente más tarde";
			return "";
		}
	}
	
	
	
	
	

	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * @return the rePassword
	 */
	public String getRePassword() {
		return rePassword;
	}

	/**
	 * @param rePassword the rePassword to set
	 */
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
}
