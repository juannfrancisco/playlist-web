/**
 * 
 */
package cl.accenture.curso_java.playlist.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.accenture.curso_java.playlist.modelo.Conexion;
import cl.accenture.curso_java.playlist.modelo.ObjetoNoEncontradoException;
import cl.accenture.curso_java.playlist.modelo.Perfil;
import cl.accenture.curso_java.playlist.modelo.SinConexionException;

/**
 * @author jmaldonado
 *
 */
public class PerfilDAO {

	/**
	 * Obtiene un perfil segun su identificador
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static Perfil obtenerPerfil(int id) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from perfil where idperfil =? ;");
		st.setInt(1,  id );
		ResultSet rs = st.executeQuery();
		if( rs.next() ){
			Perfil perfil = new Perfil();
			perfil.setId( rs.getInt("idperfil") );
			perfil.setNombre( rs.getString("nombre") );
			perfil.setPermisos( PermisoDAO.obtenerPermisos(perfil) );
			return perfil;
		}
		throw new ObjetoNoEncontradoException("El perfil no existe");
	}
}
