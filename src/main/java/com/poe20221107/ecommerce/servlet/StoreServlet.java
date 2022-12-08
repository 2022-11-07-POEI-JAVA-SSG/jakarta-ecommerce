package com.poe20221107.ecommerce.servlet;

import com.poe20221107.ecommerce.model.Article;
import com.poe20221107.ecommerce.model.Basket;
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
        String showbasket = request.getParameter("showbasket");
        if(showbasket != null && showbasket.equals("true")){
            
            Basket basket = (Basket)request.getSession().getAttribute("basket");
            if(basket == null){
                basket = new Basket();
            }
            
            // affichage JSP
            request.setAttribute("articles", basket.getArticles());
            request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);
        } else {
             // affichage JSP
            request.setAttribute("articles", store.getArticles());
            request.getRequestDispatcher("WEB-INF/store.jsp").forward(request, response);
        }    
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        try {
            // recuperation des données
              String idString = request.getParameter("articleid");
            int id = Integer.parseInt(idString);
            
            // retrouver article
            Article article = store.findArticle(id);
            
            // ajouter au panier
            Basket basket = (Basket)request.getSession().getAttribute("basket");
            if(basket == null){
                basket = new Basket();           
            }
            basket.addArticle(article);
            
            // sauvegarder le panier
            request.getSession().setAttribute("basket", basket);

            // affichage JSP
            request.setAttribute("articles", basket.getArticles());
            request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);

        }
        catch(Exception e){
            
        }
    }
}
