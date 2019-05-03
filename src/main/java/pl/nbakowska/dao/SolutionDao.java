package pl.nbakowska.dao;

import pl.nbakowska.db.DbUtil;
import pl.nbakowska.model.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {

    public static void saveOrUpdate(Solution solution) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (solution.getId() == 0) {
            String sql = "INSERT INTO solutions (created, updated, description, exercise_id, user_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            setSolutionData(solution, ps);
            ps.executeUpdate();
        } else {
            String sql = "UPDATE solutions SET created=?, updated=?, description=?, exercise_id=? user_id = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            setSolutionData(solution, ps);
            ps.setInt(6,solution.getId());
            ps.executeUpdate();
        }
    }

    private static void setSolutionData(Solution solution, PreparedStatement ps) throws SQLException {
        ps.setTimestamp(1, solution.getCreated());
        ps.setTimestamp(2, solution.getUpdated());
        ps.setString(3, solution.getDescription());
        ps.setInt(4, solution.getUserId());
        ps.setInt(5, solution.getExerciseId());
    }

    static public Solution findSolutionById(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM Solution where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return mapAllSolutions(resultSet).get(0);
    }


    static public List<Solution> loadAllSolutions() throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM solutions";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return mapAllSolutions(resultSet);
    }

    public static void deleteSolution(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (id != 0) {
            String sql = "DELETE FROM solutions WHERE id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static List<Solution> findAllByUserId(int userId) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM solutions where users_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet resultSet = ps.executeQuery();
        return mapAllSolutions(resultSet);
    }

    public static List<Solution> findAllByExerciseId(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM solutions where exercise_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        return mapAllSolutions(resultSet);
    }

    private static List<Solution> mapAllSolutions(ResultSet resultSet) throws SQLException {
        List<Solution> solutions = new ArrayList<>();
        while (resultSet.next()) {
            Solution solution = new Solution();
            solution.setId(resultSet.getInt("id"));
            solution.setCreated(resultSet.getTimestamp("created"));
            solution.setUpdated(resultSet.getTimestamp("updated"));
            solution.setDescription(resultSet.getString("description"));
            solution.setExerciseId(resultSet.getInt("exerciseId"));
            solution.setUserId(resultSet.getInt("userId"));
            solutions.add(solution);
        }
        return solutions;
    }
}
