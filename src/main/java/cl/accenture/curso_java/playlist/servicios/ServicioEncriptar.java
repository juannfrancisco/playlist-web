/**
 * 
 */
package cl.accenture.curso_java.playlist.servicios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Juan Francisco Maldonado León
 *
 */
public class ServicioEncriptar {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(ServicioEncriptar.encriptar("xx"));
	}
	
	
	/**
	 * 
	 * @param texto
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String encriptar( String texto) 
			throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance( "SHA1" );
	      md.update("texto a cifrar".getBytes());
	      byte[] digest = md.digest();
	      // Se escribe codificado base 64. Se necesita la librería
	      // commons-codec-x.x.x.jar de Apache 
	      byte[] encoded = Base64.encodeBase64(digest);
		return new String(encoded);
	}

}
