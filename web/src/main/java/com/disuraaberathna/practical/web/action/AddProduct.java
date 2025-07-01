package com.disuraaberathna.practical.web.action;

import com.disuraaberathna.practical.core.model.Product;
import com.disuraaberathna.practical.core.service.ProductService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(@HttpConstraint(rolesAllowed = {"SUPER_ADMIN", "ADMIN"}))
@WebServlet("/admin/add-product")
public class AddProduct extends HttpServlet {
    @EJB
    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("productName").trim();
        String description = req.getParameter("productDescription").trim();
        String price = req.getParameter("productPrice").trim();
        String quantity = req.getParameter("productQuantity").trim();
        String category = req.getParameter("productCategory").trim();

        Product product = new Product(name, description, Double.parseDouble(price), Double.parseDouble(quantity), category);

        productService.addProduct(product);

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
