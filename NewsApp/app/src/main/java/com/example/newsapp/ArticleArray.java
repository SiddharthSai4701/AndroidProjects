/*
* newsapi returns an object containing multiple properties
* Of these properties, the one of interest is articles which is an array.
* This class handles the articles returned in the object
* */
package com.example.newsapp;

import java.util.ArrayList;

public class ArticleArray {
    private String status;
    private String totalResults;
    private ArrayList<ModelClass> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }

    public ArticleArray(String status, String totalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
