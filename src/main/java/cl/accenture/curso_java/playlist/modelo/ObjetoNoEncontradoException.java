package cl.accenture.curso_java.playlist.modelo;

/**
 * 
 * @author jmaldonado
 *
 */
public class ObjetoNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 7868638582693049829L;
	
	
	/**
	 * 
	 * @param message
	 */
	public ObjetoNoEncontradoException(String message) {
		super(message);
	}

}
