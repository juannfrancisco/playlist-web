/**
 * 
 */
package cl.accenture.curso_java.playlist.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.playlist.modelo.Conexion;
import cl.accenture.curso_java.playlist.modelo.Perfil;
import cl.accenture.curso_java.playlist.modelo.Permiso;
import cl.accenture.curso_java.playlist.modelo.SinConexionException;

/**
 * @author jmaldonado
 *
 */
public class PermisoDAO {

	
	/**
	 * Obtiene todos los permisos de un determinado perfil
	 * @param perfil
	 * @return
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static List<Permiso> obtenerPermisos(Perfil perfil) throws SQLException, SinConexionException {
		List<Permiso> permisos = new ArrayList<Permiso>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from perfil_permiso where id_perfil =? ;");
		st.setInt(1,  perfil.getId() );
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			Permiso permiso = new Permiso();
			permiso.setIdentificador( rs.getString("id_permiso") );
			permisos.add( permiso );
		}
		return permisos;
	}
}
