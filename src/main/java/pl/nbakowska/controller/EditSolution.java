package pl.nbakowska.controller;

import pl.nbakowska.dao.SolutionDao;
import pl.nbakowska.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/solutions/edit")
public class EditSolution extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("id", id);
        getServletContext().getRequestDispatcher("/editSolution.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Solution oldSolution = new Solution();
        try {
            oldSolution = SolutionDao.findSolutionById(Integer.parseInt(req.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String description = req.getParameter("description");
        int exerciseId = Integer.parseInt(req.getParameter("exerciseId"));
        int userId = Integer.parseInt(req.getParameter("userId"));



        Solution solution = new Solution();
        solution.setId(Integer.parseInt(req.getParameter("id")));
        solution.setCreated(oldSolution.getCreated());
        solution.setUpdated(new Timestamp(new Date().getTime()));
        solution.setDescription(description != null ? description : oldSolution.getDescription());
        solution.setExerciseId(exerciseId != 0 ? exerciseId : oldSolution.getExerciseId());
        solution.setUserId(userId != 0 ? userId : oldSolution.getUserId());

        try {
            SolutionDao.saveOrUpdate(solution);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
