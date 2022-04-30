package com.belajar.resepmakanan.api;

import com.belajar.resepmakanan.models.RandomResep;
import com.belajar.resepmakanan.models.SearchResep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/api/recipes/1")
    Call< RandomResep > getRandomResep();

    @GET("/api/search/")
    Call< SearchResep > getSearhResep(@Query("q")String nama_makanan);

}
