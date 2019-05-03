package pl.nbakowska.controller;

import pl.nbakowska.dao.UserDao;
import pl.nbakowska.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/groups/users/{id}")
public class UsersInGroupServlet extends HttpServlet {
    List<User> users;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            users = UserDao.loadAllByGroupId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/users.jsp");
    }
}
