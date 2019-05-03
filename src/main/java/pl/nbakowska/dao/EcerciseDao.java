package pl.nbakowska.dao;

import pl.nbakowska.db.DbUtil;
import pl.nbakowska.model.Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EcerciseDao {

    public static void saveOrUpdate(Exercise exercise) throws SQLException {
        Connection connection = DbUtil.getConn();

        if (exercise.getId() == 0) {
            String sql = "INSERT INTO Exercise(title, description) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, exercise.getTitle());
            ps.setString(2, exercise.getDescription());
            ps.executeUpdate();
        }else {
            String sql = "UPDATE Exercise SET title=?, description=? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, exercise.getTitle());
            ps.setString(2, exercise.getDescription());
            ps.setInt(3, exercise.getId());
            ps.executeUpdate();
        }
    }

    static public Exercise findExerciseById(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM Exercise where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        return mapAllxercises(resultSet).get(0);
    }

    static public List<Exercise> findAllExercises() throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM Exercise";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return mapAllxercises(resultSet);
    }

    static public void deleteExerCiseById(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        if (id != 0) {
            String sql = "DELETE FROM Exercise WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    private static List<Exercise> mapAllxercises(ResultSet resultSet) throws SQLException {
        List <Exercise> exercises = new ArrayList<>();
        while (resultSet.next()) {
            Exercise exercise = new Exercise();
            exercise.setId(resultSet.getInt("id"));
            exercise.setTitle(resultSet.getString("title"));
            exercise.setDescription(resultSet.getString("description"));
            exercises.add(exercise);
        }
        return exercises;
    }
}
