package pl.nbakowska.dao;

import pl.nbakowska.db.DbUtil;
import pl.nbakowska.model.User;
import pl.nbakowska.model.UserGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {

    public void saveUserGroup(UserGroup userGroup) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (userGroup.getId() == 0) {
            String sql = "INSERT INTO User_group(name) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userGroup.getName());
            ps.executeUpdate();
        }else {
            String sql = "UPDATE User_group SET name=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userGroup.getName());
            ps.executeUpdate();
        }
    }

    static public UserGroup findGroupById(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM User_group where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        return mapAllUserGroups(resultSet).get(0);
    }

    static public List<UserGroup> findAllGroups() throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM User_group";
        PreparedStatement pa = connection.prepareStatement(sql);
        ResultSet resultSet = pa.executeQuery();
        return mapAllUserGroups(resultSet);
    }

    public void deleteUserGroup(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (id != 0) {
            String sql = "DELETE FROM User_group WHERE id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private static List<UserGroup> mapAllUserGroups(ResultSet resultSet) throws SQLException {
        List<UserGroup> userGroups = new ArrayList<>();
        while (resultSet.next()) {
            UserGroup userGroup = new UserGroup();
            userGroup.setId(resultSet.getInt("id"));
            userGroup.setName(resultSet.getString("name"));
            userGroups.add(userGroup);
        }
        return userGroups;
    }
}
