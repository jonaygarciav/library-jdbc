package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MySQL {

	public MySQL() {
		
	}
	
	public void probarConexion() {
		System.out.println("-------- Probando la Conexion a Base de Datos ------------");

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error a la hora de cargar el Driver JDBC de MySQL.");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver JDBC de MySQL cargado correctamente.");
		
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/booksdb?autoReconnect=true&useSSL=false", "booksdb_user", "booksdb_user");

		} catch (SQLException e) {
			System.out.println("Error al intentar conectar a BBDD");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("Conexión a Base de Datos correcta");
		} else {
			System.out.println("Error al intentar conectar a BBDD");
		}
		
	}
	
}
