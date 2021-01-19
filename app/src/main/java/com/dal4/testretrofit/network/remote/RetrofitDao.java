package com.dal4.testretrofit.network.remote;

import com.dal4.testretrofit.models.MoviesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RetrofitDao {

    @GET("title/auto-complete")
    Call<MoviesModel> getMoves(
            @Header("x-rapidapi-host") String api,
            @Header("x-rapidapi-key") String apiKey,
            @Query("q") String MovieName
    );

}
