/**
 * 
 */
package cl.accenture.curso_java.playlist.modelo;

import java.util.List;

/**
 * @author jmaldonado
 *
 */
public class Playlist {
	
	private int id;
	private String nombre;
	private String descripcion;
	private List<Cancion> canciones;
	
	
	public Playlist() {
	}
	
	/**
	 * 
	 * @param id
	 */
	public Playlist(int id) {
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
	 * @return the canciones
	 */
	public List<Cancion> getCanciones() {
		return canciones;
	}

	/**
	 * @param canciones the canciones to set
	 */
	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

}
