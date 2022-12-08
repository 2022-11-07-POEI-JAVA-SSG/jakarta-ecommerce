package com.poe20221107.ecommerce.servlet;

import com.poe20221107.ecommerce.model.Store;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {

    private Store store = new Store();
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        // affichage JSP
        request.setAttribute("articles", store.getArticles());
        request.getRequestDispatcher("WEB-INF/store.jsp").forward(request, response);
    }

}
