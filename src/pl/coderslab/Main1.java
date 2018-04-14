package pl.coderslab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.Scanner;

import pl.coderslab.models.Exercise;
import pl.coderslab.models.Solution;
import pl.coderslab.models.User_group;
import pl.coderslab.models.Users;

public class Main1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//usersManagement(scan);
		//exerciseManagement(scan);
		//groupManagement(scan);
		//matchSolution(scan);
		scan.close();
	}

	private static void usersManagement(Scanner scan) {
		while(true) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2_ex?useSSL=false",
                "root", "coderslab")) {
			
			Users[] myUsers = Users.loadAllUsers(conn);
			for (int i =0; i<myUsers.length; i++) {
				System.out.println("Id: " + myUsers[i].getId() +
						" Username: " + myUsers[i].getUsername() + 
						" Email: " + myUsers[i].getEmail() + 
						" User group id: " + myUsers[i].getUser_group_id());
			}
			
			String username = "";
			String email = "";
			String password= "";
			int user_group_id = 0;
			//włożyć w pętlę while
			System.out.println("Select option: " + "\n" + "add/edit/delete/quit");
			
			
			String myChoice = scan.nextLine();
			if (myChoice.equalsIgnoreCase("add")) {
				String[] myData = insertUserData(scan);
				username = myData[0];
				email = myData[1];
				password = myData[2];
				user_group_id = Integer.parseInt(myData[3]);
				Users user1 = new Users(username, email, password, user_group_id);
				user1.saveToDB(conn);
			} else if (myChoice.equalsIgnoreCase("edit")){
				Users myUser = Users.loadUserById(conn, findItem(scan));
				String[] myData = insertUserData(scan);
				myUser.setUsername(myData[0]);
				myUser.setEmail(myData[1]);
				myUser.setPassword(myData[2]);
				myUser.setUser_group_id(Integer.parseInt(myData[3]));
				myUser.saveToDB(conn);
				
			} else if (myChoice.equalsIgnoreCase("delete")){
				Users myUser = Users.loadUserById(conn, findItem(scan));
				myUser.delete(conn);
				
			} else if (myChoice.equalsIgnoreCase("quit")){
				System.out.println("The end");
				break;
			}else {	
				System.out.println("Invalid input");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			break;
			
		}
		}
		
	}
	
	private static void exerciseManagement(Scanner scan) {
		while(true) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2_ex?useSSL=false",
                "root", "coderslab")) {
			
			Exercise[] myExercises = Exercise.loadAllExercises(conn);
			for (int i =0; i<myExercises.length; i++) {
				System.out.println("Id: " + myExercises[i].getId() +
						" Title: " + myExercises[i].getTitle() + 
						" Description: " + myExercises[i].getDescription());

			}
			
			String title = "";
			String description = "";
		
			
			System.out.println("Select option: " + "\n" + "add/edit/delete/quit");
			
		
			String myChoice = scan.nextLine();
		
			if (myChoice.equalsIgnoreCase("add")) {
				String[] myData = insertExerciseData(scan);
				title = myData[0];
				description = myData[1];
				
				Exercise exercise1 = new Exercise(title, description);
				exercise1.saveToDB(conn);
			} else if (myChoice.equalsIgnoreCase("edit")){
				Exercise myExercise = Exercise.loadExerciseById(conn, findItem(scan));
				String[] myData = insertExerciseData(scan);
				myExercise.setTitle(myData[0]);
				myExercise.setDescription(myData[1]);				
				myExercise.saveToDB(conn);
			} else if (myChoice.equalsIgnoreCase("delete")){
				Exercise myExercise = Exercise.loadExerciseById(conn, findItem(scan));
				myExercise.delete(conn);
				
			} else if (myChoice.equalsIgnoreCase("quit")){
				System.out.println("The end");
				break;
			}else {	
				System.out.println("Invalid input");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			break;
			
		}
		}
	}
	
	private static void groupManagement(Scanner scan) {
		while(true) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2_ex?useSSL=false",
                "root", "coderslab")) {
			
			User_group[] myGroup = User_group.loadAllGroups(conn);
			for (int i =0; i<myGroup.length; i++) {
				System.out.println("Id: " + myGroup[i].getId() +
						" Name: " + myGroup[i].getName());

			}
			
			String name = "";
			System.out.println("Select option: " + "\n" + "add/edit/delete/quit");
			
	
			String myChoice = scan.nextLine();
			if (myChoice.equalsIgnoreCase("add")) {
				String[] myData = insertGroupData(scan);
				name = myData[0];
				
				User_group group1 = new User_group(name);
				group1.saveToDB(conn);
			} else if (myChoice.equalsIgnoreCase("edit")){
				User_group myGroup2 = User_group.loadGroupById(conn, findItem(scan));
				String[] myData = insertGroupData(scan);
				myGroup2.setName(myData[0]);
			} else if (myChoice.equalsIgnoreCase("delete")){
				User_group myGroup3 = User_group.loadGroupById(conn, findItem(scan));
				myGroup3.delete(conn);
				
			} else if (myChoice.equalsIgnoreCase("quit")){
				System.out.println("The end");
				break;
			}else {	
				System.out.println("Invalid input");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			break;
			
		}
		}
	}
	
	private static void matchSolution(Scanner scan) {
		while(true) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2_ex?useSSL=false",
                "root", "coderslab")) {
		
			System.out.println("Select option: " + "\n" + "add/viev/quit");
			
			String myChoice = scan.nextLine();
		
			if (myChoice.equalsIgnoreCase("add")) {
				
				Users[] myUsers = Users.loadAllUsers(conn);
				for (int i =0; i<myUsers.length; i++) {
					System.out.println("Id: " + myUsers[i].getId() +
							" Username: " + myUsers[i].getUsername() + 
							" Email: " + myUsers[i].getEmail() + 
							" User group id: " + myUsers[i].getUser_group_id());

				}
				int idUser = findItem(scan);
				
				Exercise[] myExercises = Exercise.loadAllExercises(conn);
				for (int i =0; i<myExercises.length; i++) {
					System.out.println("Id: " + myExercises[i].getId() +
							" Title: " + myExercises[i].getTitle() + 
							" Description: " + myExercises[i].getDescription());

				}
				int idExercise = findItem(scan);
				
				Solution mySolution = new Solution();
				mySolution.setCreated(new Timestamp(System.currentTimeMillis()));
				mySolution.setUpdated(null);
				mySolution.setDescription(null);
				mySolution.setExercise_id(idExercise);
				mySolution.setUsers_id(idUser);
				mySolution.saveToDB(conn);
			
			} else if (myChoice.equalsIgnoreCase("viev")){
				int idUser = findItem(scan);
				Solution[] mySolutions = Solution.loadAllByUserId(conn, idUser);
				for (int i =0; i<mySolutions.length; i++) {
					System.out.println("Id: " + mySolutions[i].getId() +
							" Description: " + mySolutions[i].getDescription() + 
							" User id: " + mySolutions[i].getUsers_id() +
							" Exercise id: " + mySolutions[i].getExercise_id());
				}
			} else if (myChoice.equalsIgnoreCase("quit")){
				System.out.println("The end");
				break;
			}else {	
				System.out.println("Invalid input");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			break;
			
		}
		}
	}
	
	
	static public String[] insertUserData(Scanner scan) {
		String[] data = new String[4];
		System.out.println("Insert username");
		data[0] = scan.nextLine();
		System.out.println("Insert email");
		data[1] = scan.nextLine();
		System.out.println("Insert password");
		data[2] = scan.nextLine();
		System.out.println("Insert group id");
		data[3] = scan.nextLine();
		return data;
	}
	
	static public String[] insertExerciseData(Scanner scan) {
		String[] data = new String[2];
		System.out.println("Insert title");
		data[0] = scan.nextLine();
		System.out.println("Insert description");
		data[1] = scan.nextLine();
		return data;
	}
	
	static public String[] insertGroupData(Scanner scan) {
		String[] data = new String[1];
		System.out.println("Insert group name");
		data[0] = scan.nextLine();
		return data;
	}
	

	static public int findItem(Scanner scan) {
		System.out.println("Insert id: ");
		int id = scan.nextInt();
		return id;
	}
}
