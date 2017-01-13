package com.example.tom.recycler_view;

import com.example.tom.recycler_view.model.Weather;
import com.example.tom.recycler_view.models.WeatherAPIResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tom on 1/13/2017.
 */

//?id=524901&APPID=

public interface RetrofitInterface {
//    @GET("forecast/city")
//    Call<Weather> getWeather (@Query("id") String id, @Query("APPID") String api_key);
//
//    @GET("forecast/{name}")
//    Call<Weather> getDetails (@Path("name") String nama_kota, @Query("api_key") String api_key);

    @GET("/data/2.5/forecast/daily")
    Call<WeatherAPIResult> getWeather(@Query("id") int cityID, @Query("APPID") String appID);
}
