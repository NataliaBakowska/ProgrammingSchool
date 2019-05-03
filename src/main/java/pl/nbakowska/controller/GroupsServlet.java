package pl.nbakowska.controller;

import pl.nbakowska.dao.UserGroupDao;
import pl.nbakowska.model.UserGroup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/groups/all")
public class GroupsServlet extends HttpServlet {

    List<UserGroup> groups;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            groups = UserGroupDao.findAllGroups();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("groups", groups);

        getServletContext().getRequestDispatcher("/groups.jsp").forward(req, resp);
    }
}
