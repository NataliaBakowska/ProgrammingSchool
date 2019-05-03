package pl.nbakowska.dao;

import pl.nbakowska.db.DbUtil;
import pl.nbakowska.model.UserGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {

    public static void saveOrUpdate(UserGroup userGroup) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (userGroup.getId() == 0) {
            String sql = "INSERT INTO user_groups(name, description) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userGroup.getName());
            ps.setString(2, userGroup.getDescription());
            ps.executeUpdate();
        }else {
            String sql = "UPDATE user_groups SET name=?, description=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userGroup.getName());
            ps.setString(2, userGroup.getDescription());
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
        String sql = "SELECT * FROM user_groups";
        PreparedStatement pa = connection.prepareStatement(sql);
        ResultSet resultSet = pa.executeQuery();
        return mapAllUserGroups(resultSet);
    }

    public static void deleteUserGroup(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (id != 0) {
            String sql = "DELETE FROM user_groups WHERE id= ?";
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
            userGroup.setDescription(resultSet.getString("description"));
            userGroups.add(userGroup);
        }
        return userGroups;
    }
}
