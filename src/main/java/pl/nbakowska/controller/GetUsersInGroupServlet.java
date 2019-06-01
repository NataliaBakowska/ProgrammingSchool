package pl.nbakowska.controller;

import pl.nbakowska.dao.UserDao;
import pl.nbakowska.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users/all/group")
public class GetUsersInGroupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>(0);
        try {
            users = UserDao.loadAllByGroupId(Integer.parseInt(req.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/users.jsp").forward(req,resp);
    }
}
