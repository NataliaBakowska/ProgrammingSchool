package pl.coderslab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

import pl.coderslab.models.Users;

public class Main1 {

	public static void main(String[] args) {
		//connection w oddzielnej metodzie
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2_ex?useSSL=false",
                "root", "coderslab")) {
			Users user1 = new Users();
			//user1.setUsername("user1");
			//user1.setEmail("email@email.com");
			//user1.setPassword("haslo");
			//user1.saveToDB(conn);
			
			//wołamy usera pod danym id, przypisujemy do obiektu, zmieniamy email i zapisujemy metodą save to db
			Users user123 = Users.loadUserById(conn, 5);
			//user123.setEmail("mail@mail.pl");
			//user123.saveToDB(conn);
			//System.out.println(user123.getEmail());
			
			user123.delete(conn);
			System.out.println(user123.getId());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
