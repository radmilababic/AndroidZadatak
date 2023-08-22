package com.example.makeuptask.networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIs {
    String BASE_URL="https://makeup-api.herokuapp.com/api/v1/";

    @GET("products.json")
    Call<List<ProductResult>> getProducts(@Query("brand")String brand);
}
