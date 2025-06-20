package com.cache.dto;

import java.io.Serializable;

public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String city;
    private String temp;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
