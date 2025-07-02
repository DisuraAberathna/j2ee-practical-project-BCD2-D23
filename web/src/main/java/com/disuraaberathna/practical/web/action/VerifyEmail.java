package com.disuraaberathna.practical.web.action;

import com.disuraaberathna.practical.core.model.Status;
import com.disuraaberathna.practical.core.model.User;
import com.disuraaberathna.practical.core.service.UserService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;

@WebServlet("/verify")
public class VerifyEmail extends HttpServlet {
    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String vc = req.getParameter("vc");

        byte[] bytes = Base64.getDecoder().decode(id);
        String email = new String(bytes);

        User user = userService.getUserByEmail(email);
        if (user != null && user.getVerificationCode().equals(vc)) {
            user.setStatus(Status.ACTIVE);
            user.setVerificationCode(null);
            userService.verifyUser(user);
        }

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
