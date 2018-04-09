package pl.coderslab.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users {

	private int id;
    private String username;
    private String password;
    private String email;
    
    public Users(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.setPassword(password);
    	
    }
    
    public Users() {}
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	


	public void saveToDB(Connection conn) throws SQLException {
		if (this.id == 0) {
			String sql = "INSERT INTO Users(username, email, password) VALUES (?, ?, ?)";
			//jakie kolumny po zapisie nowego obiektu baza ma nam zwrócić - w tym przypadku interesuje nas id
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, this.username);
			preparedStatement.setString(2, this.email);
			preparedStatement.setString(3, this.password);
			preparedStatement.executeUpdate();
			//tutaj jest wynik naszego zapytania - generated column
			ResultSet rs = preparedStatement.getGeneratedKeys();
			//jeśli nie istnieje to go zapisze??
			if (rs.next()) {
				this.id = rs.getInt(1);
			}else {
			    String sql2 = "UPDATE Users SET username=?, email=?, password=? where id = ?";
			    PreparedStatement preparedStatement2;
			    preparedStatement = conn.prepareStatement(sql);
			    preparedStatement.setString(1, this.username);
			    preparedStatement.setString(2, this.email);
			    preparedStatement.setString(3, this.password);
			    preparedStatement.setInt(4, this.id);
			    preparedStatement.executeUpdate();
			}	
		}
	}
		
	static public Users loadUserById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM Users where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		//czytamy nie zmieniamy, więc query
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			//pobieramy wartości z resultseta i przypisujemy do stworzonego przed chwilą użytkownika
			Users loadedUser = new Users();
			loadedUser.id = resultSet.getInt("id");
			loadedUser.username = resultSet.getString("username");
			loadedUser.password = resultSet.getString("password");
			loadedUser.email = resultSet.getString("email");
			return loadedUser;}
		return null;
	}
	
	static public Users[] loadAllUsers(Connection conn) throws SQLException {
	    ArrayList<Users> users = new ArrayList<Users>();
	    String sql = "SELECT * FROM Users"; PreparedStatement preparedStatement;
	    preparedStatement = conn.prepareStatement(sql);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
	        Users loadedUser = new Users();
	        loadedUser.id = resultSet.getInt("id");
	        loadedUser.username = resultSet.getString("username");
	        loadedUser.password = resultSet.getString("password");
	        loadedUser.email = resultSet.getString("email");
	        users.add(loadedUser);}
	    Users[] uArray = new Users[users.size()]; uArray = users.toArray(uArray);
	    return uArray;}
	
	public void delete(Connection conn) throws SQLException {
	    if (this.id != 0) {
	        String sql = "DELETE FROM Users WHERE id= ?";
	        PreparedStatement preparedStatement;
	        preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setInt(1, this.id);
	        preparedStatement.executeUpdate();
	        this.id=0;
	    }
	}


}
