package com.poe20221107.ecommerce.model;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Article> articles = new ArrayList<>();

    public ArrayList<Article> getArticles() {
        return articles;
    }
    
    public void addArticle(Article article){
        articles.add(article);
    }
    
}
