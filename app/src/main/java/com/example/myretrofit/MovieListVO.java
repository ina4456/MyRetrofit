package com.example.myretrofit;

import java.util.ArrayList;

public class MovieListVO {
    private String category;
    private ArrayList<Movie> list;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public ArrayList<Movie> getList() {
        return list;
    }

    public void setList(ArrayList<Movie> list) {
        this.list = list;
    }

}

