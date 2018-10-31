package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {

    private String city;
    private double mag;
    private Date date;
    private String url;

    public Earthquake(String city, double mag, Date date, String url) {
        this.city = city;
        this.mag = mag;
        this.date = date;
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
