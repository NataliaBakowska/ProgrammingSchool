package pl.nbakowska.controller;

import pl.nbakowska.dao.SolutionDao;
import pl.nbakowska.model.Solution;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/solutions/add")
public class NewSolutionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addSolution.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        int exerciseId = Integer.parseInt(req.getParameter("exerciseId"));
        int userId = Integer.parseInt(req.getParameter("userId"));

        Date date= new Date();
        long time = date. getTime();

        try {
            SolutionDao.saveOrUpdate(new Solution(new Timestamp(time), new Timestamp(time), description, exerciseId, userId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
