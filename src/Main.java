

import java.sql.SQLException;
import java.util.Scanner;

import jdbc.AuthorDao;
import jdbc.MySQL;

public class Main {

	
	public static String prueba(String campo) {
		Scanner input = new Scanner(System.in);
		
		System.out.print(campo + ": ");
		String valor = input.nextLine();
		input.close();
		return valor;
	}
	
	public static void main(String[] args) throws SQLException {
		

		Integer opcion = 1;
		
		MySQL ms = new MySQL();
		AuthorDao dd = new AuthorDao();
		Scanner input = new Scanner(System.in);
		do {

			System.out.println("");
			System.out.println("1.- Probar conexion a Base de Datos.");
			System.out.println("2.- Listar todos los autores.");
			System.out.println("3.- Contar los autores.");
			System.out.println("4.- Insertar autor.");
			System.out.println("5.- Actualizar un autor (por identificador).");			
			System.out.println("6.- Borrar un autor (por identificador).");
			System.out.println("0.- Salir");
            System.out.println("");
			System.out.print("Opcion: ");
			
			opcion = input.nextInt();
			
			if (opcion == 1) {
				
				ms.probarConexion();
			}
			else if (opcion == 2) {
				dd.obtenerAutores();
			}
			else if (opcion == 3) {
				dd.contarAutores();
			}			
			else if (opcion == 4) {
				Scanner sc4 = new Scanner(System.in);
				
				System.out.println("Introduzca un nombre: ");
				String first_name = sc4.nextLine();
				System.out.println("Introduzca apellidos: ");
				String last_name = sc4.nextLine();
				
				dd.insertarAutor(first_name, last_name);	
			}
			else if (opcion == 5) {
				Scanner sc5 = new Scanner(System.in);

				System.out.println("Introduzca un nombre: ");
				String first_name = sc5.nextLine();
				System.out.println("Introduzca apellidos: ");
				String last_name = sc5.nextLine();
				System.out.println("Introduzca un id de autor: ");
				Integer author_id = sc5.nextInt();				
				
				dd.actualizarAutor(author_id, first_name, last_name);	
			}			
			else if (opcion == 6) {
				Scanner sc6 = new Scanner(System.in);
				
				System.out.println("Introduzca id del departamento: ");
				String author_id = sc6.nextLine();
				
				dd.eliminarAutor(author_id);					
			}

			
		} while (opcion != 0);
		input.close();	
		
	

	}

}
