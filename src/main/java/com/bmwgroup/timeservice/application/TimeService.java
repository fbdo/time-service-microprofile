package com.bmwgroup.timeservice.application;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.joda.time.DateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TimeService {

    @Inject
    private TimeClient client;

    public DateTime now() {
        return client.now();
    }
}
