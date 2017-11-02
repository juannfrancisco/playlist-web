/**
 * 
 */
package cl.accenture.curso_java.playlist.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.accenture.curso_java.playlist.modelo.Conexion;
import cl.accenture.curso_java.playlist.modelo.SinConexionException;
import cl.accenture.curso_java.playlist.modelo.Usuario;

/**
 * @author jmaldonado
 *
 */
public class UsuarioDAO {

	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static boolean validar(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from usuario where "+
				"userName =?  AND "+  
				"password = ?;");
		st.setString(1,  usuario.getNombreUsuario() );
		st.setString(2,  usuario.getPassword() );
		ResultSet rs = st.executeQuery();
		return rs.next();
	}
}
