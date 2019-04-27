package pl.nbakowska.dao;

import pl.nbakowska.db.DbUtil;
import pl.nbakowska.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static void saveOrUpdate(User user) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (user.getId() == 0) {
            String sql = "INSERT INTO Users(username, email, password, user_group) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            setUserData(user, ps);
            ps.executeUpdate();
        } else {
            String sql = "UPDATE Users SET username=?, email=?, password=?, user_group=? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            setUserData(user, ps);
            ps.setInt(5, user.getId());
            ps.executeUpdate();
        }
    }

    private static void setUserData(User user, PreparedStatement ps) throws SQLException {
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());
        ps.setInt(4, user.getUserGroupId());
    }

    static public User findUserById(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM Users where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        return mapAllUsers(resultSet).get(0);
    }

    static public List<User> loadAllUsers() throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM Users";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        return mapAllUsers(resultSet);
    }

    public void deleteUser(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "DELETE FROM Users WHERE id= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        if (id != 0) {
            ps.executeUpdate();
        }
    }

    public static List<User> loadAllByGroupId(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM Users where user_group_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        return mapAllUsers(resultSet);
    }

    private static List<User> mapAllUsers(ResultSet resultSet) throws SQLException {
        List<User> allUsers = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setUserGroupId(resultSet.getInt("user_group_id"));
            allUsers.add(user);
        }
        return allUsers;
    }

}
