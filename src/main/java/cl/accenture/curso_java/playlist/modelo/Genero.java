/**
 * 
 */
package cl.accenture.curso_java.playlist.modelo;

/**
 * @author jmaldonado
 *
 */
public class Genero {
	
	private int id;
	private String nombre;
	
	
	public Genero() {
	}
	
	public Genero(int id) {
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
	
	

}
