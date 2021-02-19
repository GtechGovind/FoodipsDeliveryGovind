package com.gtech.foodipsdelivery.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/auth/login.php")
    Call<ResponseBody> LoginUser(
            @Field("username") String username,
            @Field("password") String password);
}
