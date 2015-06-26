package service;

import data.Channel;

/**
 * Created by senjaRP on 6/26/2015.
 */
public interface WeatherServiceCallback {
    void serviceSuccess (Channel channel);
    void serviceFailure (Exception exception);
}

