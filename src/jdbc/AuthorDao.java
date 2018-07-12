package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class AuthorDao {

    private Connection connection = null;
    private Statement statement = null;
    //private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
	public AuthorDao() {
		
	}
	
	
	public void obtenerAutores() throws SQLException {
		
		String sqlQuery = "SELECT author_id, first_name, last_name FROM author";
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/booksdb?autoReconnect=true&useSSL=false", "booksdb_user", "booksdb_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(sqlQuery);

            System.out.println("");
            while (resultSet.next()) {
            	String author_id = resultSet.getString("author_id");
            	String first_name = resultSet.getString("first_name");
            	String last_name = resultSet.getString("last_name");
            	System.out.println(author_id + ";" + first_name + ";" + last_name);
            }

        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
		
	}
	
	
	public void contarAutores() throws SQLException {
		
		String sqlQuery = "SELECT COUNT(*) FROM author";
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/booksdb?autoReconnect=true&useSSL=false", "booksdb_user", "booksdb_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(sqlQuery);

            System.out.println("");
            resultSet.next();
            Integer numAuthors = resultSet.getInt(1);
           	System.out.println(numAuthors);

        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
		
	}	
	
	public void insertarAutor(String first_name, String last_name) throws SQLException {
		
		String sqlQuery = "INSERT INTO author (first_name, last_name) VALUES (\"" + first_name + "\", \"" + last_name + "\")";
		System.out.println(sqlQuery);
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/booksdb?autoReconnect=true&useSSL=false", "booksdb_user", "booksdb_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
       
            statement.executeUpdate(sqlQuery);
            System.out.println("Author " + first_name + " insertado correctamente.");
        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            statement.close();
            connection.close();
        }
		
	}

	
	public void actualizarAutor(Integer author_id, String first_name, String last_name) throws SQLException {
		
		String sqlQuery = "UPDATE author SET first_name = \"" + first_name + "\", last_name = \"" + last_name + "\" WHERE author_id = " + author_id;
		System.out.println(sqlQuery);
		
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            //connect = DriverManager
             //       .getConnection("jdbc:mysql://localhost/feedback?"
             //               + "user=sqluser&password=sqluserpw");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/booksdb?autoReconnect=true&useSSL=false", "booksdb_user", "booksdb_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
       
            statement.executeUpdate(sqlQuery);
            System.out.println("Author " + first_name + " insertado correctamente.");
        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            statement.close();
            connection.close();
        }
		
	}
	
	public void eliminarAutor(String author_id) throws SQLException {
		
		String sqlQuery = "DELETE FROM author WHERE author_id = \"" + author_id + "\"";
		System.out.println(sqlQuery);
		
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configurar la conexion a Base de Datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/booksdb?autoReconnect=true&useSSL=false", "booksdb_user", "booksdb_user");
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
            // Result set get the result of the SQL query
       
            statement.execute(sqlQuery);
            System.out.println("Author " + author_id + " borrado correctamente.");
        } catch (Exception e) {
        	e.printStackTrace();
			
		} finally {
            statement.close();
            connection.close();
        }
		
	}	
	
}
