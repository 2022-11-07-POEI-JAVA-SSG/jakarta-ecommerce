package com.poe20221107.ecommerce.model;

import java.util.ArrayList;


public class Store {
    
    private ArrayList<Article> articles = new ArrayList<>();
    private int nextId = 1;
    
    
    public Store(){
        addArticle(new Article("smartphone"));
        addArticle(new Article("tv"));
        addArticle(new Article("tablette"));
    }
    

    public ArrayList<Article> getArticles() {
        return articles;
    }
    
    public void addArticle(Article article){
        article.setId(nextId);
        nextId++;
        articles.add(article);
    }
    
}
