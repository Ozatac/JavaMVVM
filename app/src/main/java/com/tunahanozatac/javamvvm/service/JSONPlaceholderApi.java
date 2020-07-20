package com.tunahanozatac.javamvvm.service;


import com.tunahanozatac.javamvvm.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderApi {

    //Get
    // istek yolladık.
    @GET("users")
    Call<List<UserModel>> getData(); //liste içerisinde JSONPlaceholderModel gelecek method getData.

}
