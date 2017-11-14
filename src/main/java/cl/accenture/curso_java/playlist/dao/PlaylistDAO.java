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
import cl.accenture.curso_java.playlist.modelo.Playlist;
import cl.accenture.curso_java.playlist.modelo.SinConexionException;
import cl.accenture.curso_java.playlist.modelo.Usuario;

/**
 * @author jmaldonado
 *
 */
public class PlaylistDAO {

	/**
	 * Obtiene todas las canciones del sistema.
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static List<Playlist> obtenerPlaylists(String usuario) throws SQLException, SinConexionException {
		List<Playlist> playlists = new ArrayList<Playlist>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from playlist where id_usuario=?;");
		st.setString(1, usuario);
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			Playlist playlist = new Playlist();
			playlist.setId( rs.getInt("idplaylist") );
			playlist.setNombre( rs.getString("nombre") );
			playlist.setDescripcion( rs.getString("descripcion") );
			playlists.add(playlist);
		}
		return playlists;
	}
	
	
	/**
	 * Agrega una cancion en la base de datos
	 * @param cancion
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static void agregarPlaylist(Playlist playlist, Usuario usuario) throws SQLException, SinConexionException{
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into playlist (nombre, id_usuario, descripcion) values(?,?,?);");
		st.setString(1,playlist.getNombre() );
		st.setString(2,usuario.getNombreUsuario() );
		st.setString(3,playlist.getDescripcion() );
		st.executeUpdate();
	}
	
	/**
	 * 
	 * @param playlist
	 * @param cancion
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static void agregarCancion( Playlist playlist, Cancion cancion ) throws SQLException, SinConexionException{
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into playlist_cancion (id_playlist, id_cancion) values(?,?);");
		st.setInt(1, playlist.getId());
		st.setInt(2, cancion.getId());
		st.executeUpdate();
	}
	
	
	/**
	 * 
	 * @param playlist
	 * @return
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static List<Cancion> obtenerCanciones(Playlist playlist) throws SQLException, SinConexionException {
		List<Cancion> canciones = new ArrayList<Cancion>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from playlist_cancion where id_playlist=?;");
		st.setInt( 1, playlist.getId() );
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			int idCancion = rs.getInt("id_cancion");
			Cancion cancion = CancionDAO.obtenerCancion(idCancion);
			canciones.add(cancion);
		}
		return canciones;
	}
	
	/**
	 * 
	 * @param cancion
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static void eliminarPlaylist( Playlist playlist ) throws SQLException, SinConexionException{
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"delete from playlist where idplaylist = ?;");
		st.setInt(1, playlist.getId() );
		st.executeUpdate();
	}
	
	
}
