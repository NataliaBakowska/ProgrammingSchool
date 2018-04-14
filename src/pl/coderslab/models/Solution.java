package pl.coderslab.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;



public class Solution {

	private int id;
	private Timestamp created;
	private Timestamp updated;
	private String description;
	private int exercise_id;
	private int users_id;
	
	public Solution() {}
	
	public Solution(String created,String updated, String description, int exercise_id, int users_id ) {
		
		Timestamp myDate = Timestamp.valueOf(created);
    	this.created = myDate;
    	
    	Timestamp myDate2 = Timestamp.valueOf(updated);
		this.updated = myDate2;
		this.description = description;
		this.exercise_id = exercise_id;
		this.users_id = users_id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getId() {
		return id;
	}

	public void saveToDB(Connection conn) throws SQLException {
		if (this.id == 0) {
			String sql = "INSERT INTO Solution(created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
			//jakie kolumny po zapisie nowego obiektu baza ma nam zwrócić - w tym przypadku interesuje nas id
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setTimestamp(1, this.created);
			preparedStatement.setTimestamp(2, this.updated);
			preparedStatement.setString(3, this.description);
			preparedStatement.setInt(4, this.exercise_id);
			preparedStatement.setInt(5, this.users_id);
			preparedStatement.executeUpdate();
			//tutaj jest wynik naszego zapytania - generated column
			ResultSet rs = preparedStatement.getGeneratedKeys();
			//jeśli nie istnieje to go zapisze
			//jeśli istnieje to zrobi update
			if (rs.next()) {
				this.id = rs.getInt(1);
			}
		}else {
			  String sql2 = "UPDATE Users SET created=?, updated=?, description=?, exercise_id=? users_id = ?";
			  PreparedStatement preparedStatement2;
			  preparedStatement2 = conn.prepareStatement(sql2);
			  preparedStatement2.setTimestamp(1, this.created);
			  preparedStatement2.setTimestamp(2, this.updated);
			  preparedStatement2.setString(3, this.description);
			  preparedStatement2.setInt(5, this.exercise_id);
			  preparedStatement2.setInt(4, this.users_id);
			  preparedStatement2.executeUpdate();
			
		}
	}
		
	static public Solution loadSolutionById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM Solution where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		//czytamy nie zmieniamy, więc query
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			//pobieramy wartości z resultseta i przypisujemy do stworzonego przed chwilą użytkownika
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getTimestamp("created");
			loadedSolution.updated = resultSet.getTimestamp("updated");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			return loadedSolution;
			}
		return null;
	}
	
	static public Solution[] loadAllSolutions(Connection conn) throws SQLException {
	    ArrayList<Solution> solution = new ArrayList<Solution>();
	    String sql = "SELECT * FROM Solution"; 
	    PreparedStatement preparedStatement;
	    preparedStatement = conn.prepareStatement(sql);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
	    	Solution loadedSolution = new Solution();
	    	loadedSolution.id = resultSet.getInt("id");
	    	loadedSolution.created = resultSet.getTimestamp("created");
	    	loadedSolution.updated = resultSet.getTimestamp("updated");
	    	loadedSolution.description = resultSet.getString("description");
	    	loadedSolution.exercise_id = resultSet.getInt("exercise_id");
	    	loadedSolution.users_id = resultSet.getInt("users_id");
	        solution.add(loadedSolution);
	    }
	    Solution[] sArray = new Solution[solution.size()]; sArray = solution.toArray(sArray);
	    return sArray;
	}
	
	public void delete(Connection conn) throws SQLException {
	    if (this.id != 0) {
	        String sql = "DELETE FROM Solution WHERE id= ?";
	        PreparedStatement preparedStatement;
	        preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setInt(1, this.id);
	        preparedStatement.executeUpdate();
	        this.id=0;
	    }
	}

	public static Solution[] loadAllByUserId(Connection conn, int id) throws SQLException {
		ArrayList<Solution> userSolutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM Solution where users_id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
	    	loadedSolution.created = resultSet.getTimestamp("created");
	    	loadedSolution.updated = resultSet.getTimestamp("updated");
	    	loadedSolution.description = resultSet.getString("description");
	    	loadedSolution.exercise_id = resultSet.getInt("exercise_id");
	    	loadedSolution.users_id = resultSet.getInt("users_id");
	        userSolutions.add(loadedSolution);
	        }
		Solution[] usArray = new Solution[userSolutions.size()]; 
		usArray = userSolutions.toArray(usArray);
		return usArray;
	}

	public static Solution[] loadAllByExerciseId(Connection conn, int id) throws SQLException {
		ArrayList<Solution> exerciseSolutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM Solution where exercise_id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
	    	loadedSolution.created = resultSet.getTimestamp("created");
	    	loadedSolution.updated = resultSet.getTimestamp("updated");
	    	loadedSolution.description = resultSet.getString("description");
	    	loadedSolution.exercise_id = resultSet.getInt("exercise_id");
	    	loadedSolution.users_id = resultSet.getInt("users_id");    	
	    	exerciseSolutions.add(loadedSolution);
	    }
		
		Solution[] esArray = new Solution[exerciseSolutions.size()]; 
		esArray = exerciseSolutions.toArray(esArray);
		return esArray;
	}
}

