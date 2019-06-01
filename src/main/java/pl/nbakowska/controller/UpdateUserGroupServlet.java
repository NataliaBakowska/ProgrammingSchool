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

@WebServlet("/users/edit")
public class UpdateUserGroupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("id", id);
        getServletContext().getRequestDispatcher("/editUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        int userGroupId = Integer.parseInt(req.getParameter("userGroupId"));
        int id = Integer.parseInt(req.getParameter("id"));

        User user = new User();
        User oldUser = null;
        try {
            oldUser = UserDao.findUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        user.setId(oldUser.getId());
        user.setPassword(oldUser.getPassword());
        user.setEmail(email != null ? email : oldUser.getEmail());
        user.setUserGroupId(userGroupId != 0 ? userGroupId : oldUser.getUserGroupId());
        user.setUsername(username != null && !username.isEmpty() ? username : oldUser.getUsername());

        try {
            UserDao.saveOrUpdate(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
