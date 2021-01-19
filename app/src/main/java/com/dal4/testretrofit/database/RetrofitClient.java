package com.dal4.testretrofit.database;

import com.dal4.testretrofit.models.MoviesModel;
import com.dal4.testretrofit.network.remote.RetrofitDao;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String BASE_URL = "https://imdb8.p.rapidapi.com/";
    private RetrofitDao retrofitDao;

    private static RetrofitClient retrofitClient;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitDao = retrofit.create(RetrofitDao.class);
    }

    public static RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public Call<MoviesModel> getMovies(String MovieName, String api, String apiKey) {

        return retrofitDao.getMoves(api, apiKey, MovieName);
    }
}
