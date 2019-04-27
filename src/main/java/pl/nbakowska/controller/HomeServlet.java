package pl.nbakowska.controller;

import pl.nbakowska.dao.UserDao;
import pl.nbakowska.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("Hello World");

        try {
            UserDao.saveOrUpdate(new User("name", "email", "password"));
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("zjebalo sieeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        } finally {
            out.print("Added user");
        }
    }
}
