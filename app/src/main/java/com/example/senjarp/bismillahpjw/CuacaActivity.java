package com.example.senjarp.bismillahpjw;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import data.Channel;
import service.YahooWeatherService;


public class CuacaActivity extends ActionBarActivity {

    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuaca);

        weatherIconImageView = (ImageView) findViewById (R.id.weatherIconImageView);
        temperatureTextView = (TextView) findViewById (R.id.temperatureTextView);
        conditionTextView = (TextView) findViewById (R.id.conditionTextView);
        locationTextView = (TextView) findViewById (R.id.locationTextView);

        service = new YahooWeatherService(this);
        service.refreshWeather("Jakarta, Indonesia");
    }

    @Override
    public void ServiceSuccess (Channel channel) {

    }

    @Override
    public void serviceFailure(Exception exception) {
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }

}
