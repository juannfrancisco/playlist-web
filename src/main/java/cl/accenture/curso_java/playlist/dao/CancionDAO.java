/**
 * 
 */
package cl.accenture.curso_java.playlist.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.playlist.modelo.Cancion;
import cl.accenture.curso_java.playlist.modelo.Conexion;
import cl.accenture.curso_java.playlist.modelo.ObjetoNoEncontradoException;
import cl.accenture.curso_java.playlist.modelo.SinConexionException;

/**
 * @author jmaldonado
 *
 */
public class CancionDAO {

	
	public static Cancion obtenerCancion( int id ) throws SQLException, SinConexionException{
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from cancion where idcancion=?;");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			Cancion cancion = new Cancion();
			cancion.setId( rs.getInt("idcancion") );
			cancion.setNombre( rs.getString("nombre") );
			cancion.setArtista( rs.getString("artista") );
			cancion.setDuracion( rs.getInt("duracion") );
			cancion.setGenero( rs.getString("genero") );
			return cancion;
		}
		throw new ObjetoNoEncontradoException("La cancion no existe");
	}
	
	
	/**
	 * Obtiene todas las canciones del sistema.
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static List<Cancion> obtenerCanciones() throws SQLException, SinConexionException {
		List<Cancion> canciones = new ArrayList<Cancion>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from cancion;");
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			Cancion cancion = new Cancion();
			cancion.setId( rs.getInt("idcancion") );
			cancion.setNombre( rs.getString("nombre") );
			cancion.setArtista( rs.getString("artista") );
			cancion.setDuracion( rs.getInt("duracion") );
			cancion.setGenero( rs.getString("genero") );
			canciones.add(cancion);
		}
		return canciones;
	}
	
	
	/**
	 * Agrega una cancion en la base de datos
	 * @param cancion
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static void agregarCancion(Cancion cancion) throws SQLException, SinConexionException{
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into cancion (nombre, duracion,artista,genero) values(?,?,?,?);");
		st.setString(1,cancion.getNombre() );
		st.setInt(2,cancion.getDuracion() );
		st.setString(3,cancion.getArtista() );
		st.setString(4,cancion.getGenero() );
		st.executeUpdate();
	}
	
	
	/**
	 * 
	 * @param cancion
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static void eliminarCancion( Cancion cancion ) throws SQLException, SinConexionException{
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"delete from cancion where idcancion = ?;");
		st.setInt(1, cancion.getId() );
		st.executeUpdate();
	}
	
	
}
