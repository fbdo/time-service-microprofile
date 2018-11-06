package com.bmwgroup.timeservice.application;

import org.joda.time.DateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class TimeService {

    @Inject
    @Named("reliable")
    private TimeClient client;

    public DateTime now() {
        return client.now();
    }
}
