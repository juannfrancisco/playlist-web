/**
 * 
 */
package cl.accenture.curso_java.playlist.modelo;

import java.util.List;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 * Estructura Base para Perfil.
 *
 */
public class Perfil {
	
	private int id;
	private String nombre;
	private List<Permiso> permisos;
	
	
	public Perfil() {
		
	}
	
	public Perfil(int id) {
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the permisos
	 */
	public List<Permiso> getPermisos() {
		return permisos;
	}


	/**
	 * @param permisos the permisos to set
	 */
	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

}
