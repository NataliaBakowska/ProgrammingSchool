package pl.coderslab;

import java.sql.Connection;
import java.sql.DriverManager;

import pl.coderslab.models.Exercise;
import pl.coderslab.models.Solution;
import pl.coderslab.models.User_group;
import pl.coderslab.models.Users;

public class Main1 {

	public static void main(String[] args) {
		//connection w oddzielnej metodzie
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2_ex?useSSL=false",
                "root", "coderslab")) {
			//Users user2 = new Users();
			//user2.setUsername("user1");
			//user2.setEmail("mail@email.com");
			//user2.setPassword("haslo");
			//user2.saveToDB(conn);
			
			//wołamy usera pod danym id, przypisujemy do obiektu, zmieniamy email i zapisujemy metodą save to db
			//Users user123 = Users.loadUserById(conn, 3);
			//user123.setEmail("mail@mail.pl");
			//user123.saveToDB(conn);
			//System.out.println(user123.getEmail());
			
			//user123.delete(conn);
			//System.out.println(user123.getId());
			//User_group group1 = new User_group("grupa1");
			//group1.saveToDB(conn);
			//User_group id = User_group.loadGroupById(conn, 1);
			//id.setName("grupa1a");
			//System.out.println(id.getName());
			//id.saveToDB(conn);
			//User_group id1 = User_group.loadGroupById(conn, 1);
			//System.out.println(id1.getName());
			
			//User_group groupMy = User_group.loadGroupById(conn, 2);
			//System.out.println(groupMy.getName());
			//groupMy.delete(conn);
			
			//Exercise exercise2 = new Exercise("second exercise", "description2");
			//exercise2.saveToDB(conn);
			//Exercise exercise1a = Exercise.loadExerciseById(conn, 1);
			//exercise1a.setTitle("my first exercise");
			//exercise1a.saveToDB(conn);
			
			//Exercise [] example = Exercise.loadAllExercises(conn);
			//System.out.println(example[0].getDescription());
			//exercise1a.delete(conn);
			
			Solution solution1 = new Solution(created, updated, "desc1", 2, 1)
			solution1.saveToDB(conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
