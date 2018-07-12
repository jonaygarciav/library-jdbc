package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class BookDao {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
	public BookDao() {
		
	}
	
	
	public void obtenerUsuarios() throws SQLException {
		
		String sqlQuery = "SELECT id_usuario, nombre, apellido1, apellido2 FROM usuario";
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/cip?autoReconnect=true&useSSL=false", "cip_user", "cip_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(sqlQuery);

            System.out.println("");
            while (resultSet.next()) {
            	String id_departmento = resultSet.getString("id_departamento");
            	String nombre = resultSet.getString("nombre");
            	String descripcion = resultSet.getString("descripcion");
            	System.out.println(id_departmento + ";" + nombre + ";" + descripcion);
            }

        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
		
	}
	
	
	public void contarDepartamentos() throws SQLException {
		
		String sqlQuery = "SELECT COUNT(*) FROM departamento";
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/cip?autoReconnect=true&useSSL=false", "cip_user", "cip_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(sqlQuery);

            System.out.println("");
            resultSet.next();
            Integer numDepartamentos = resultSet.getInt(1);
           	System.out.println(numDepartamentos);

        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
		
	}	
	
	public void insertarDepartamento(String nombre, String descripcion) throws SQLException {
		
		String sqlQuery = "INSERT INTO departamento (nombre, descripcion) VALUES (\"" + nombre + "\", \"" + descripcion + "\")";
		System.out.println(sqlQuery);
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/cip?autoReconnect=true&useSSL=false", "cip_user", "cip_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
       
            statement.executeUpdate(sqlQuery);
            System.out.println("Departamento " + nombre + " insertado correctamente.");
        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            statement.close();
            connection.close();
        }
		
	}

	
	public void actualizarDepartamento(Integer id_departamento, String nombre, String descripcion) throws SQLException {
		
		String sqlQuery = "UPDATE departamento SET nombre = \"" + nombre + "\", descripcion = \"" + descripcion + "\" WHERE id_departamento = " + id_departamento;
		System.out.println(sqlQuery);
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/cip?autoReconnect=true&useSSL=false", "cip_user", "cip_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
       
            statement.executeUpdate(sqlQuery);
            System.out.println("Departamento " + nombre + " insertado correctamente.");
        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            statement.close();
            connection.close();
        }
		
	}
	
	public void eliminarDepartamento(String id_departamento) throws SQLException {
		
		String sqlQuery = "DELETE FROM departamento WHERE id_departamento = \"" + id_departamento + "\"";
		System.out.println(sqlQuery);
		
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configurar la conexi�n a Base de Datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/cip?autoReconnect=true&useSSL=false", "cip_user", "cip_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
       
            statement.execute(sqlQuery);
            System.out.println("Departamento " + id_departamento + " borrado correctamente.");
        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            statement.close();
            connection.close();
        }
		
	}	
	
}
