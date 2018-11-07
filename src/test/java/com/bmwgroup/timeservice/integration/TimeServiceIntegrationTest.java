package com.bmwgroup.timeservice.integration;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Arquillian.class)
@RunAsClient
public class TimeServiceIntegrationTest {

    @ArquillianResource // injected service URL for test container
    private URL base;

    @Deployment
    public static WebArchive createDeployment() {

        WebArchive war = ShrinkWrap.createFromZipFile(WebArchive.class, new File("build/libs/ROOT.war"));

        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void testGetNow() {

        DateTime now = DateTime.now();

        given()
                .accept("application/json")
                .baseUri(base.toString())
                .log().all()
                .get("/now")
                .prettyPeek()
                .then()
                .body("hours", equalTo(now.getHourOfDay()))
                .and()
                .body("day", equalTo(now.getDayOfMonth()));
    }
}
