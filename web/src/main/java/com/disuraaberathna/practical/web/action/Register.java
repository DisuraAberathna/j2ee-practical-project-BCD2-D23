package com.disuraaberathna.practical.web.action;

import com.disuraaberathna.practical.core.model.User;
import com.disuraaberathna.practical.core.model.UserType;
import com.disuraaberathna.practical.core.service.UserService;
import com.disuraaberathna.practical.core.util.Encryption;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @EJB
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String hashedPassword = Encryption.encryption(password);

        User user = new User(name, contact, email, hashedPassword, UserType.USER);

        userService.addUser(user);

        resp.sendRedirect(req.getContextPath()+"/login.jsp");
    }
}
