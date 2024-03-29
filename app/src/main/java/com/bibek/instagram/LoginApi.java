package com.bibek.instagram;

import com.bibek.instagram.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    //for Register
    @POST("instagram/users/register")
    Call<Void> register(@Body UserModel user);


    //for Login
    @POST("instagram/users/login")
    Call<Void> login(@Body UserModel user);

}
