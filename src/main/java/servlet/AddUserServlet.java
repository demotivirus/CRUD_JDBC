package servlet;

import models.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addUser.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        User user = new User(
                req.getParameter("name"),
                req.getParameter("password"),
                Integer.valueOf(req.getParameter("age")));

        UserService userService = UserService.getInstance();
        userService.addUser(user);
        resp.setStatus(200);
        req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
    }
}
