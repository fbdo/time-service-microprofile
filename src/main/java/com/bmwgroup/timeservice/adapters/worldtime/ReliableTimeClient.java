package com.bmwgroup.timeservice.adapters.worldtime;

import com.bmwgroup.timeservice.application.TimeClient;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.joda.time.DateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@ApplicationScoped
@Named("reliable")
public class ReliableTimeClient implements TimeClient {

    private static Logger LOG = Logger.getLogger(ReliableTimeClient.class.getName());

    @Inject
    @Named("worldtime")
    private TimeClient decorated;

    @Override
    @Retry
    @CircuitBreaker
    @Fallback(fallbackMethod = "reliableNow")
    public DateTime now() {
        return decorated.now();
    }

    public DateTime reliableNow() {
        LOG.warning("Access to time service failed, using reliable intra-VM source instead");

        return DateTime.now();
    }
}
