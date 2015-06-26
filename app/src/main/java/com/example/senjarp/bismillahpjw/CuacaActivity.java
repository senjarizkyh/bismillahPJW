package com.example.senjarp.bismillahpjw;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import data.Channel;
import service.WeatherServiceCallback;
import service.YahooWeatherService;


public class CuacaActivity extends ActionBarActivity  implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperaturetextView;
    private TextView conditionTextview;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuaca);

        weatherIconImageView = (ImageView) findViewById(R.id.weatherIconImageView);
        temperaturetextView = (TextView) findViewById(R.id.temperatureTextView);
        conditionTextview = (TextView) findViewById(R.id.conditionTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this, getApplicationContext());
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Jakarta, Indonesia");
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }

}
