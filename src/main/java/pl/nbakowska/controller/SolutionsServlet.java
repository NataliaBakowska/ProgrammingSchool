package pl.nbakowska.controller;

import pl.nbakowska.dao.SolutionDao;
import pl.nbakowska.model.Solution;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/solutions/all")
public class SolutionsServlet extends HttpServlet {

    private List<Solution> solutions;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            solutions = SolutionDao.loadAllSolutions();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/solutions.jsp").forward(req,resp);
    }
}
