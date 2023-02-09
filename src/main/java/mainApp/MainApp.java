package mainApp;

import org.hibernate.Session;

import daos.UserManagementService;
import models.Usuario;

public class MainApp {

	public static void main(String[] args) {
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		
		UserManagementService userService = new UserManagementService(session);
		
		Usuario user1 = new Usuario();
		user1.setNombre("Suhail");
		user1.setUserName("Thesuha");
		
		
		Usuario user2 = new Usuario();
		user2.setNombre("Reme");
		user2.setUserName("REM3ME");
		
		Usuario userRepetido = new Usuario();
		userRepetido.setNombre("Suhail");
		userRepetido.setUserName("5uh4");		
		
		userService.insertNewUser(user1);
		userService.insertNewUser(user2);;
		userService.insertNewUser(userRepetido);
		
		
		System.out.println("\nConsulta rapida");
		System.out.println("searchAll");
		System.out.println(userService.searchAll());
		System.out.println("searchByName");
		System.out.println(userService.searchByName("Suhail"));
		System.out.println("searchById");
		System.out.println(userService.searchById((long) 2));
		session.close();
	}
}
