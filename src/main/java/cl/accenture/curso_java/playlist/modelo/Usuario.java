/**
 * 
 */
package cl.accenture.curso_java.playlist.modelo;

import java.util.Date;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Estructura Base para Usuario.
 *
 */
public class Usuario {

	private String nombreUsuario;
	private String password;
	private int intentosFallidos;
	private Date ultimoIngreso;
	
	public Usuario() {
		
	}
	
	

	/**
	 * @param nombreUsuario
	 * @param password
	 * @param intentosFallidos
	 */
	public Usuario(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
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
	 * @return the intentosFallidos
	 */
	public int getIntentosFallidos() {
		return intentosFallidos;
	}

	/**
	 * @param intentosFallidos the intentosFallidos to set
	 */
	public void setIntentosFallidos(int intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}



	/**
	 * @return the ultimoIngreso
	 */
	public Date getUltimoIngreso() {
		return ultimoIngreso;
	}



	/**
	 * @param ultimoIngreso the ultimoIngreso to set
	 */
	public void setUltimoIngreso(Date ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}
	
	
	
}
