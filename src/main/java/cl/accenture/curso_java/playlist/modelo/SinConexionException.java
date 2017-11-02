package cl.accenture.curso_java.playlist.modelo;

public class SinConexionException extends Exception {

	private static final long serialVersionUID = -3568938731476591193L;

	/**
	 * 
	 * @param mensaje
	 */
	public SinConexionException(String mensaje){
		super(mensaje);
	}
}