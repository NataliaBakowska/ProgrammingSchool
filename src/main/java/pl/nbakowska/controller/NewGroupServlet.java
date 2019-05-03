package pl.nbakowska.controller;

import pl.nbakowska.dao.EcerciseDao;
import pl.nbakowska.dao.UserGroupDao;
import pl.nbakowska.model.Exercise;
import pl.nbakowska.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/groups/add")
public class NewGroupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addGroup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("descriptio");

        try {
            UserGroupDao.saveOrUpdate(new UserGroup(name, description));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
