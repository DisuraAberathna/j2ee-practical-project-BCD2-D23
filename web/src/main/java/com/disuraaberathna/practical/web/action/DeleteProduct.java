package com.disuraaberathna.practical.web.action;

import com.disuraaberathna.practical.core.service.ProductService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/delete-product")
public class DeleteProduct extends HttpServlet {
    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        productService.deleteProduct(Long.parseLong(id));

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
