package pl.nbakowska.controller;

import pl.nbakowska.dao.EcerciseDao;
import pl.nbakowska.model.Exercise;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exercises/add")
public class NewExerciseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addExercise.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        try {
            EcerciseDao.saveOrUpdate(new Exercise(title, description));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
