package com.bmwgroup.timeservice.ports.restapi;

import com.bmwgroup.timeservice.application.TimeService;
import org.joda.time.DateTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RequestScoped
@Path("/")
public class TimeController {

    @Inject
    private TimeService service;

    @GET
    @Path("/now")
    @Produces(MediaType.APPLICATION_JSON)
    public TimeResource now() {
        DateTime now = service.now();
        TimeResource time = new TimeResource(now.getSecondOfMinute(), now.getMinuteOfHour(), now.getHourOfDay(), now.getDayOfMonth(), now.getMonthOfYear(), now.getYear());
        return time;
    }
}
