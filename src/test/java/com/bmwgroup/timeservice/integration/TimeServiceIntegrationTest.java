package com.bmwgroup.timeservice.integration;

import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.joda.time.DateTime;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Arquillian.class)
@RunAsClient
public class TimeServiceIntegrationTest {

    @ArquillianResource // injected service URL for test container
    private URL base;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(8080).notifier(new ConsoleNotifier(true)));


    @Deployment
    public static WebArchive createDeployment() {

        WebArchive war = ShrinkWrap.
                createFromZipFile(WebArchive.class, new File("build/libs/ROOT.war"))
                .addAsResource(Thread.currentThread().getContextClassLoader().getResource("META-INF/microprofile-config.properties"), "META-INF/microprofile-config.properties");

        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void testGetNow() {

        stubFor(get(urlEqualTo("/api/ip"))
                .withHeader("Accept", containing("application/json"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("wiremock/worldtime_by_ip_response.json")));

        given()
                .accept("application/json")
                .baseUri("http://localhost:" + base.getPort())
                .log().all()
                .get("/now")
                .prettyPeek()
                .then()
                .body("seconds", equalTo(45))
                .and()
                .body("minutes", equalTo(20))
                .and()
                .body("hours", equalTo(20))
                .and()
                .body("day", equalTo(4));
    }
}
