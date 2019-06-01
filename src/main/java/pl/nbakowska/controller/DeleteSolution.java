package pl.nbakowska.controller;

import pl.nbakowska.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/solutions/delete")
public class DeleteSolution extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SolutionDao.deleteSolution(Integer.parseInt(req.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
