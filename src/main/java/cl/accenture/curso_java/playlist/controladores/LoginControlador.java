/**
 * 
 */
package cl.accenture.curso_java.playlist.controladores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.playlist.dao.UsuarioDAO;
import cl.accenture.curso_java.playlist.modelo.Usuario;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Controlador Login.
 *
 */
@ManagedBean
@SessionScoped
public class LoginControlador implements Serializable {

	private static final long serialVersionUID = -6848126621941457061L;
	private String nombreUsuario;
	private String password;
	private String mensaje;
	private boolean error;
	private Usuario usuarioLogeado;
	
	
	public LoginControlador() {
		this.nombreUsuario = "";
		this.password = "";
		this.mensaje = "";
		this.usuarioLogeado = new Usuario();
		
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
	public String iniciarSesion(){
		try {
			boolean usuarioValido = UsuarioDAO.validar(new Usuario(this.nombreUsuario, this.password));
			if( usuarioValido ){
				this.mensaje = "";
				this.error = false;
				return "principal?faces-redirect=true";
			}else{
				this.error = true;
				this.mensaje = "Usuario y/o Password incorrectos";
				return "";
			}
		} catch (Exception e) {
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
	 * @return the usuarioLogeado
	 */
	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	/**
	 * @param usuarioLogeado the usuarioLogeado to set
	 */
	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}
	
}
