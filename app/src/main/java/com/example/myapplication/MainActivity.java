package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;
import retrofit2.http.GET;

import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.showData);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApi jsonPlaceHolderApi = retrofit.create(JsonApi.class);

       // Call<List<Clouds>> callClouds = jsonPlaceHolderApi.getCoord(44.34, 10.99, "503731d3cb394ea86dc6cfdd6cdb357a");
//        Call<List<Coord>> callCoord = jsonPlaceHolderApi.getCoord();
//        Call<List<Main>> callMain = jsonPlaceHolderApi.getMain();
//        Call<List<MainActivity>> callMainActivity = jsonPlaceHolderApi.getMainActivity();
//        Call<List<Sys>> callSys = jsonPlaceHolderApi.getSys();
//        Call<List<Weather>> callWeather = jsonPlaceHolderApi.getWeather();
//        Call<List<Wind>> callWind = jsonPlaceHolderApi.getWind();
        Call<WeatherResponse> weatherResponse = jsonPlaceHolderApi.weatherResponse(44.34, 10, "503731d3cb394ea86dc6cfdd6cdb357a");

        weatherResponse.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (!response.isSuccessful()) {
                   textView.setText("Code:" + response.code());
               }
                WeatherResponse weatherResponses = response.body();
//                for(WeatherResponse weatherResponse1: weatherResponses){
//                    String content = "";
//                    content += weatherResponse1.getCoord().getLat() + "\n";
//
//                }
                String content = "";
                content += weatherResponses.getClouds().getAll() + "\n";
                textView.append(content);

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });
//        callClouds.enqueue(new Callback<List<Clouds>>() {
//            @Override
//            public void onResponse(Call<List<Clouds>> call, Response<List<Clouds>> response) {
//                if (!response.isSuccessful()) {
//                    textView.setText("Code:" + response.code());
//                }
//
//                List<Clouds> clods = response.body();
//                for (Clouds cloud : clods) {
//                    String content = "";
//                    content += cloud.getAll() + "\n";
//                    textView.append(content);
//                }
////                String content = "";
////                content += clouds.getAll() + "\n";
////                textView.append(content);
//            }
//
//            @Override
//            public void onFailure(Call<List<Clouds>> call, Throwable t) {
//                textView.setText(t.getMessage());
//            }
//        });

//        callCoord.enqueue(new Callback<List<Coord>>() {
//            @Override
//            public void onResponse(Call<List<Coord>> call, Response<List<Coord>> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code:" +response.code());
//                }
//                List<Coord> cords = response.body();
//                for(Coord cord : cords){
//                    String content = "";
//                    content += cord.getLon() + "\n";
//                    content += cord.getLat() + "\n";
//                    textView.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Coord>> call, Throwable t) {
//                textView.setText(t.getMessage());
//
//            }
//        });
//
//        callMain.enqueue(new Callback<List<Main>>() {
//            @Override
//            public void onResponse(Call<List<Main>> call, Response<List<Main>> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code:" +response.code());
//                }
//                List<Main> mains = response.body();
//                for(Main main : mains){
//                    String content = "";
//                    content += main.getTemp() + "\n";
//                    content += main.getFeelsLike() + "\n";
//                    content += main.getTempMin() + "\n";
//                    content += main.getTempMax() + "\n";
//                    content += main.getPressure() + "\n";
//                    content += main.getHumidity() + "\n";
//
//                    textView.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Main>> call, Throwable t) {
//                textView.setText(t.getMessage());
//
//            }
//        });
//        callMainActivity.enqueue(new Callback<List<MainActivity>>() {
//            @Override
//            public void onResponse(Call<List<MainActivity>> call, Response<List<MainActivity>> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code:" +response.code());
//                }
//                List<MainActivity> activities = response.body();
//                for(MainActivity activity  : activities){
//                    String content = "";
//                    content += activity.getCoord() + "\n";
//                    content += activity.getWeather() + "\n";
//                    content += activity.getBase() + "\n";
//                    content += activity.getMain() + "\n";
//                    content += activity.getVisibility() + "\n";
//                    content += activity.getWind() + "\n";
//                    content += activity.getClouds() + "\n";
//                    content += activity.getDt() + "\n";
//                    content += activity.getSys() + "\n";
//                    content += activity.getId() + "\n";
//                    content += activity.getName() + "\n";
//                    content += activity.getCod() + "\n";
//                    textView.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<MainActivity>> call, Throwable t) {
//                textView.setText(t.getMessage());
//
//            }
//        });
//
//        callSys.enqueue(new Callback<List<Sys>>() {
//            @Override
//            public void onResponse(Call<List<Sys>> call, Response<List<Sys>> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code:" +response.code());
//                }
//                List<Sys> syns = response.body();
//                for(Sys syn : syns){
//                    String content = "";
//                    content += syn.getType() + "\n";
//                    content += syn.getId() + "\n";
//                    content += syn.getCountry() + "\n";
//                    content += syn.getSunrise() + "\n";
//                    content += syn.getSunset() + "\n";
//
//                    textView.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Sys>> call, Throwable t) {
//                textView.setText(t.getMessage());
//
//            }
//        });
//
//        callWeather.enqueue(new Callback<List<Weather>>() {
//            @Override
//            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code:" +response.code());
//                }
//                List<Weather> weathers = response.body();
//                for(Weather weather : weathers){
//                    String content = "";
//                    content += weather.getId() + "\n";
//                    content += weather.getMain() + "\n";
//                    content += weather.getDescription() + "\n";
//                    content += weather.getIcon() + "\n";
//
//                    textView.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Weather>> call, Throwable t) {
//                textView.setText(t.getMessage());
//
//            }
//        });
//
//        callWind.enqueue(new Callback<List<Wind>>() {
//            @Override
//            public void onResponse(Call<List<Wind>> call, Response<List<Wind>> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code:" +response.code());
//                }
//                List<Wind> winds = response.body();
//                for(Wind wind : winds){
//                    String content = "";
//                    content += wind.getSpeed() + "\n";
//                    content += wind.getDeg() + "\n";
//
//                    textView.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Wind>> call, Throwable t) {
//                textView.setText(t.getMessage());
//
//            }
//        });
    }
}

