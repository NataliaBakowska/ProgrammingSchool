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
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/solutions/edit")
public class EditSolution extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        resp.setHeader("id", id);
        getServletContext().getRequestDispatcher("/addSolution.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        int exerciseId = Integer.parseInt(req.getParameter("exerciseId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        Timestamp date1 = Timestamp.valueOf(req.getParameter("created"));
        Date date= new Date();
        long time = date. getTime();
        Solution solution = new Solution( new Timestamp(date1.getTime()), new Timestamp(time), description, exerciseId, userId);
        solution.setId(Integer.parseInt(req.getHeader("id")));
        try {
            SolutionDao.saveOrUpdate(solution);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
