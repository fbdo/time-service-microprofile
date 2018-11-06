package com.bmwgroup.timeservice.adapters.worldtime;

import com.bmwgroup.timeservice.application.TimeClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.joda.time.DateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@ApplicationScoped
@Named("worldtime")
public class WorldTimeClient implements TimeClient {

    private static Logger LOG = Logger.getLogger(WorldTimeClient.class.getName());


    @Inject
    @RestClient
    private WorldTimeRestClient restClient;

    @Override
    public DateTime now() {
        LOG.fine("Requesting remote service");

        WorldTime wt = restClient.getByIP();

        return DateTime.parse(wt.getDatetime());
    }
}
