/**
 * 
 */
package cl.accenture.curso_java.playlist.modelo;

/**
 * @author jmaldonado
 *
 */
public class Playlist {
	
	private int id;
	private String nombre;
	private String descripcion;
	
	
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

}
