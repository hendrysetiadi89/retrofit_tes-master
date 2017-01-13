package com.example.tom.recycler_view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tom.recycler_view.model.Weather;
import com.example.tom.recycler_view.models.WeatherAPIResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private String URL = "http://api.openweathermap.org/data/2.5/";
    //forecast/city?id=524901&APPID=2fa1dce06d1d26759f0c7d7dd3f3d311";
    private String apikey = "2fa1dce06d1d26759f0c7d7dd3f3d311";
    private int id = 524901;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInterface retrofitInterface = RetrofitClient.getClient()
                .create(RetrofitInterface.class);

//        Call<Weather> call = retrofitInterface.getWeather(id, apikey);
        Call<WeatherAPIResult> call = retrofitInterface.getWeather(id, apikey);

        call.enqueue(new Callback<WeatherAPIResult>() {
            @Override
            public void onResponse(Call<WeatherAPIResult> call, Response<WeatherAPIResult> response) {
                int statuscode = response.code();
                String result = response.body().toString();
                Log.d("ini tes respon", result);

            }

            @Override
            public void onFailure(Call<WeatherAPIResult> call, Throwable t) {
                Log.e("ini tes error", t.toString());
            }
        });

    }



}
