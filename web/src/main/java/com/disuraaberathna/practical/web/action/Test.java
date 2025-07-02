package com.disuraaberathna.practical.web.action;

import com.disuraaberathna.practical.core.exception.LoginFailedException;
import com.disuraaberathna.practical.core.model.Product;
import com.disuraaberathna.practical.core.service.ProductService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/test")
public class Test extends HttpServlet {
    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Optional<Product> product = productService.getProductByName("abc");
        } catch (Exception e) {
            throw e;
        }
    }
}
