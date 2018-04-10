package pl.coderslab.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User_group {
	
	private int id;
	private String name;
	
	public User_group() {}
	
	public User_group(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}


	//zapisywanie grupy
	public void saveToDB(Connection conn) throws SQLException {
		if (this.id == 0) {
			String sql = "INSERT INTO User_group(name) VALUES (?)";
			//jakie kolumny po zapisie nowego obiektu baza ma nam zwrócić - w tym przypadku interesuje nas id
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, this.name);
			preparedStatement.executeUpdate();
			//tutaj jest wynik naszego zapytania - generated column
			ResultSet rs = preparedStatement.getGeneratedKeys();
			//jeśli nie istnieje to go zapisze
			//jeśli istnieje to zrobi update
			if (rs.next()) {
				this.id = rs.getInt(1);
			}
		}else {
			  String sql2 = "UPDATE User_group SET name=?";
			  PreparedStatement preparedStatement2;
			  preparedStatement2 = conn.prepareStatement(sql2);
			  preparedStatement2.setString(1, this.name);
			  preparedStatement2.executeUpdate();
				
		}
	}
	
	//wczytywanie grupy - tworzenie obiektu	
	static public User_group loadGroupById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM User_group where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		//czytamy nie zmieniamy, więc executequery
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			//pobieramy wartości z resultseta i przypisujemy do stworzonego przed chwilą użytkownika
			User_group loadedGroup = new User_group();
			loadedGroup.id = resultSet.getInt("id");
			loadedGroup.name = resultSet.getString("name");
			return loadedGroup;
		}
		return null;
	}
	
	//wczytywanie wszystkich grup
	static public User_group[] loadAllGroups(Connection conn) throws SQLException {
	    ArrayList<User_group> user_group = new ArrayList<User_group>();
	    String sql = "SELECT * FROM User_group"; 
	    PreparedStatement preparedStatement;
	    preparedStatement = conn.prepareStatement(sql);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
	        User_group loadedGroup = new User_group();
	        loadedGroup.id = resultSet.getInt("id");
	        loadedGroup.name = resultSet.getString("name");
	        user_group.add(loadedGroup);}
	    User_group[] gArray = new User_group[user_group.size()]; gArray = user_group.toArray(gArray);
	    return gArray;
	    }
	
	public void delete(Connection conn) throws SQLException {
		if (this.id != 0) {
	        String sql = "DELETE FROM User_group WHERE id= ?";
	        PreparedStatement preparedStatement;
	        preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setInt(1, this.id);
	        preparedStatement.executeUpdate();
	        this.id=0;
	    }
	}
}
