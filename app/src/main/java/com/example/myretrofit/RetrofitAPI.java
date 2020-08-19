package com.example.myretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("/contacts/")
    Call<List<Movie>> getMovieList();
}