package cl.accenture.curso_java.playlist.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * @author Juan Francisco Maldonado León - juan.maldonado.leon@gmail.com
 *
 */
public class Conexion {

	private String host;
	private int puerto;
	private String baseDeDatos;
	private String nombre;
	private String password;
	private static final String VAR_HOST_MYSQL = "MYSQL_PLAYLIST_PORT_3306_TCP_ADDR";
	private static Connection instancia = null;
	
	private Conexion() {
		this.host = "127.0.0.1"; //localhost
		this.puerto = 3306;
		this.baseDeDatos = "curso";
		this.nombre = "root";
		this.password = "java123";
		
		Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              envName,
                              env.get(envName));
        }
		
		String hostOpenShift = System.getenv(VAR_HOST_MYSQL);
		if( hostOpenShift != null ){
			this.host = hostOpenShift;
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public String getBaseDeDatos() {
		return baseDeDatos;
	}

	public void setBaseDeDatos(String baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Obtiene la conexion de la base de datos.
	 * @return
	 * @throws SinConexionException 
	 */
	private static Connection obtenerConexion() throws SinConexionException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Conexion con = new Conexion();
			String urlConexion = "jdbc:mysql://" + con.host+ ":" + con.puerto + "/" + con.baseDeDatos;
			System.out.println( urlConexion);
			Connection connection = DriverManager.getConnection( urlConexion, con.nombre, con.password );
			return connection;
		} catch (Exception e) {
			throw new SinConexionException( "No se ha podido realizar "
					+ "la conexion hacia la base de datos " + e.getMessage() , e );
		}
	}
	
	

	/**
	 * @return the instancia
	 * @throws SinConexionException 
	 */
	public static Connection getInstancia() throws SinConexionException {
		if( instancia == null ){
			instancia = obtenerConexion();
		}
		return instancia;
	}


	
}