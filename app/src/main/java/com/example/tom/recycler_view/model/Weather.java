package com.example.tom.recycler_view.model;

/**
 * Created by tom on 1/13/2017.
 */

public class Weather {

    private String country_name, description_weather, icon, humidity;

    public Weather(){}

    public Weather(String country_name, String description_weather, String humidity) {
        this.country_name = country_name;
        this.description_weather = description_weather;
        this.humidity = humidity;
    }

    public void setCountry_name(String name) {
        this.country_name = name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setDescription_weather(String deskripsi) {
        this.description_weather = deskripsi;
    }

    public String getDescription_weather() {
        return description_weather;
    }

    public void setHumidity(String lembab) {
        this.humidity = lembab;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setIcon_weather(String icon) {
        this.icon = icon;
    }

    public String getIcon_weather() {
        return icon;
    }

}
