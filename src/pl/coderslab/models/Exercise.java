package pl.coderslab.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Exercise {

	private int id;
	private String title;
	private String description;
	
	public Exercise() {}
	
	public Exercise(String title, String description) {
		this.title = title;
		this.description = description;
	}

	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public int getId() {
		return id;
	}

	public void saveToDB(Connection conn) throws SQLException {
		if (this.id == 0) {
			String sql = "INSERT INTO Exercise(title, description) VALUES (?, ?)";
			//jakie kolumny po zapisie nowego obiektu baza ma nam zwrócić - w tym przypadku interesuje nas id
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, this.title);
			preparedStatement.setString(2, this.description);
			preparedStatement.executeUpdate();
			//tutaj jest wynik naszego zapytania - generated column
			ResultSet rs = preparedStatement.getGeneratedKeys();
			//jeśli nie istnieje to go zapisze
			//jeśli istnieje to zrobi update
			if (rs.next()) {
				this.id = rs.getInt(1);
			}
		}else {
			  String sql2 = "UPDATE Exercise SET title=?, description=? where id = ?";
			  PreparedStatement preparedStatement2;
			  preparedStatement2 = conn.prepareStatement(sql2);
			  preparedStatement2.setString(1, this.title);
			  preparedStatement2.setString(2, this.description);
			  preparedStatement2.setInt(3, this.id);
			  preparedStatement2.executeUpdate();
			
		}
	}
		
	static public Exercise loadExerciseById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM Exercise where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		//czytamy nie zmieniamy, więc query
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			//pobieramy wartości z resultseta i przypisujemy do stworzonego przed chwilą użytkownika
			Exercise loadedExercise = new Exercise();
			loadedExercise.id = resultSet.getInt("id");
			loadedExercise.title = resultSet.getString("title");
			loadedExercise.description = resultSet.getString("description");
			return loadedExercise;}
		return null;
	}
	
	static public Exercise[] loadAllExercises(Connection conn) throws SQLException {
	    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	    String sql = "SELECT * FROM Exercise"; PreparedStatement preparedStatement;
	    preparedStatement = conn.prepareStatement(sql);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
	    	Exercise loadedExercise = new Exercise();
	    	loadedExercise.id = resultSet.getInt("id");
	    	loadedExercise.title = resultSet.getString("title");
	    	loadedExercise.description = resultSet.getString("description");
	        exercises.add(loadedExercise);}
	    Exercise[] eArray = new Exercise[exercises.size()]; eArray = exercises.toArray(eArray);
	    return eArray;}
	
	public void delete(Connection conn) throws SQLException {
	    if (this.id != 0) {
	        String sql = "DELETE FROM Exercise WHERE id= ?";
	        PreparedStatement preparedStatement;
	        preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setInt(1, this.id);
	        preparedStatement.executeUpdate();
	        this.id=0;
	    }
	}


	
}
