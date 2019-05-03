package pl.nbakowska.controller;

import pl.nbakowska.dao.SolutionDao;
import pl.nbakowska.model.Solution;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/solutions/ass")
public class NewSolutionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addSolution.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        int excerciseId = Integer.parseInt(req.getParameter("excerciseId"));
        int userId = Integer.parseInt(req.getParameter("userId"));

        try {
            SolutionDao.saveOrUpdate(new Solution("", "", description, excerciseId, userId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
