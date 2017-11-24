/**
 * 
 */
package cl.accenture.curso_java.playlist.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.playlist.modelo.Conexion;
import cl.accenture.curso_java.playlist.modelo.ObjetoNoEncontradoException;
import cl.accenture.curso_java.playlist.modelo.Perfil;
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
	public static Usuario validar(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from usuario where "+
				"userName =?  AND "+  
				"password = ?;");
		st.setString(1,  usuario.getNombreUsuario() );
		st.setString(2,  usuario.getPassword() );
		ResultSet rs = st.executeQuery();
		if( rs.next() ){
			Perfil perfil =PerfilDAO.obtenerPerfil( rs.getInt("id_perfil") ) ;
			usuario.setPerfil(perfil);
			usuario.setUltimoIngreso( rs.getDate("ultimoIngreso") );
			usuario.setIntentosFallidos(  rs.getInt("intentosFallidos" ) );
			return usuario;
		}
		throw new ObjetoNoEncontradoException("Usuario y/o password incorrectos");
	}

	/**
	 * 
	 * @return
	 * @throws SinConexionException 
	 * @throws SQLException 
	 */
	public static List<Usuario> obtenerUsuarios() throws SQLException, SinConexionException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from usuario");
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			Usuario usuario = new Usuario();
			Perfil perfil =PerfilDAO.obtenerPerfil( rs.getInt("id_perfil") ) ;
			usuario.setPerfil(perfil);
			usuario.setNombreUsuario( rs.getString("userName") );
			usuario.setUltimoIngreso( rs.getTimestamp("ultimoIngreso") );
			usuario.setIntentosFallidos(  rs.getInt("intentosFallidos" ) );
			usuarios.add( usuario );
		}
		return usuarios;
	}

	/**
	 * 
	 * @param usuario
	 * @throws SinConexionException 
	 * @throws SQLException 
	 */
	public static void eliminarUsuario(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"delete from usuario where userName = ?;");
		st.setString(1, usuario.getNombreUsuario() );
		st.executeUpdate();
	}
	
	/**
	 * 
	 * @param usuario
	 * @throws SQLException
	 * @throws SinConexionException
	 */
	public static void actualizarUltimoIngreso( Usuario usuario ) throws SQLException, SinConexionException{
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"update usuario set ultimoIngreso=? where userName = ?;");
		st.setTimestamp(1, new Timestamp( new java.util.Date().getTime()  ));
//		st.setDate(1, new Date( new java.util.Date().getTime() ));
		st.setString( 2, usuario.getNombreUsuario());
		st.executeUpdate();
	}

	
	/**
	 * 
	 * @param usuario
	 * @throws SQLException 
	 * @throws SinConexionException 
	 */
	public static void agregarUsuario(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into usuario (userName, password ) values(?,?);");
		st.setString(1,usuario.getNombreUsuario() );
		st.setString(2,usuario.getPassword() );
		st.executeUpdate();
	}
}
