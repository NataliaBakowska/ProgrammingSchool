//package pl.nbakowska;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import pl.nbakowska.model.Exercise;
//import pl.nbakowska.model.Solution;
//
//public class Main2 {
//
//	public static void main(String[] args) {
//		while(true) {
//			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2_ex?useSSL=false",
//	                "root", "nbakowska")) {
//				Scanner scan = new Scanner(System.in);
//				System.out.println("Podaj swoje id: ");
//				int myId = scan.nextInt();
//
//				System.out.println("Select option: " + "\n" + "add/viev/quit");
//				String myChoice = scan.next();
//
//				if (myChoice.equalsIgnoreCase("add")) {
//					Exercise[] exercises = loadUnsolvedByUserId(conn, myId);
//					for (int i = 0; i<exercises.length;i++) {
//						System.out.println(exercises[i].getDescription() + exercises[i].getTitle());
//					}
//					System.out.println("Id zadania: ");
//					int exerciseId = scan.nextInt();
//					Timestamp created = new Timestamp(System.currentTimeMillis());
//
//					Timestamp updated = new Timestamp(System.currentTimeMillis());
//
//					System.out.println("Opis zadania: ");
//					String description = scan.next();
//					Solution sol = new Solution(created.toString(), updated.toString(), description, exerciseId, myId);
//					sol.saveToDB(conn);
//
//
//				} else if (myChoice.equalsIgnoreCase("viev")){
//					Solution[] sol = Solution.loadAllByUserId(conn, myId);
//					System.out.println();
//					for (int i = 0; i<sol.length;i++) {
//						System.out.println(sol[i].getId() +" "+ sol[i].getDescription());
//					}
//				} else if (myChoice.equalsIgnoreCase("quit")){
//					System.out.println("The end");
//					break;
//
//				}else {
//					System.out.println("Invalid input");
//
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//				break;
//
//			}
//
//		}
//
//	}
//	static public Exercise[] loadUnsolvedByUserId(Connection conn, int id) throws SQLException{
//
//		ArrayList<Exercise> unsolvedExercises = new ArrayList<>();
//		String sql = "SELECT * FROM Exercise AS e LEFT JOIN Solution AS s ON e.id=s.exercise_id WHERE s.users_id = ? AND s.description IS NULL;";
//		PreparedStatement preStm = conn.prepareStatement(sql);
//		preStm.setInt(1, id);
//		ResultSet exercise = preStm.executeQuery();
//			while (exercise.next()) {
//				Exercise loadedExercise = new Exercise();
//				loadedExercise.setId(exercise.getInt("id"));
//				loadedExercise.setTitle(exercise.getString("title"));
//				loadedExercise.setDescription(exercise.getString("description"));
//				unsolvedExercises.add(loadedExercise);
//			}
//
//		Exercise[] exercisesArray = new Exercise[unsolvedExercises.size()];
//	    exercisesArray = unsolvedExercises.toArray(exercisesArray);
//		 return exercisesArray;
//	}
//	static public int findItem(Scanner scan) {
//		System.out.println("Insert id: ");
//		int id = scan.nextInt();
//		return id;
//	}
//}
