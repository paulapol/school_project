package com.example.location2.API;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ClientRetrofit {

    @POST("/position/authenticate")Call<Token>authenticate(@Body Login login);

    @POST("/position/createPosition")Call<PositionBody>create(@Header("Authorization") String authToken, @Body PositionBody positionBody);

    @GET("/position/ALLposition")Call<ResponseBody>getAll(@Header("Authorization") String authToken);

}
