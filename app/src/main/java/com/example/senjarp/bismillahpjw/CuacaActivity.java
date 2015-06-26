package com.example.senjarp.bismillahpjw;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import data.Channel;
import service.YahooWeatherService;
import android.app.ProgressDialog;


public class CuacaActivity extends ActionBarActivity  implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperaturetextView;
    private TextView conditionTextview;
    private TextView locationTextView;

    private YahooWheatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuaca);

        weatherIconImageView = (ImageView) findViewById(R.id.weatherIconImageView);
        temperaturetextView = (TextView) findViewById(R.id.temperaturetextView);
        conditionTextview = (TextView) findViewById(R.id.conditionTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);

        service = new YahooWheaterService(this);
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
    public void
    servicefailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
