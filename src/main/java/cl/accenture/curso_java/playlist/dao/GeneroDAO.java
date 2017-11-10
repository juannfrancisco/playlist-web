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
import cl.accenture.curso_java.playlist.modelo.Genero;
import cl.accenture.curso_java.playlist.modelo.SinConexionException;

/**
 * @author jmaldonado
 *
 */
public class GeneroDAO {

	
	/**
	 * Obtiene todos los generos musicales 
	 * @return
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static List<Genero> obtenerGeneros() throws SQLException, SinConexionException {
		List<Genero> generos = new ArrayList<Genero>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from genero;");
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			Genero genero = new Genero();
			genero.setId( rs.getInt("idgenero") );
			genero.setNombre( rs.getString("nombre") );
			generos.add(genero);
		}
		return generos;
	}
}
