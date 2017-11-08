/**
 * 
 */
package cl.accenture.curso_java.playlist.modelo;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 *
 */
public class Cancion {
	
	private int id;
	private String nombre;
	private int duracion;
	private String artista;
	private String genero;
	
	
	public Cancion() {
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public Cancion(int id) {
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
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}
	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	/**
	 * @return the artista
	 */
	public String getArtista() {
		return artista;
	}
	/**
	 * @param artista the artista to set
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

}
