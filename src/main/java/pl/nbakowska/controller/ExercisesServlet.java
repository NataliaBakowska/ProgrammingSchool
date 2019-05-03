package pl.nbakowska.controller;

import pl.nbakowska.dao.EcerciseDao;
import pl.nbakowska.dao.EcerciseDao;
import pl.nbakowska.model.Exercise;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exercises/all")
public class ExercisesServlet extends HttpServlet {

    List<Exercise> exercises;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            exercises = EcerciseDao.findAllExercises();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("exercises", exercises);
        getServletContext().getRequestDispatcher("/exercises.jsp").forward(req, resp);
    }
}
