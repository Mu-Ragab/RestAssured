package examples;

import dataentities.Location;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Chapter6Test {

    //@Rule
    //public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

    @Test
    public void checkResponseBody() {

        Location location =

                given().
                when().
                    get("http://api.zippopotam.us/us/90210").
                    as(Location.class);

        Assert.assertEquals(
                "Beverly Hills",
                location.getPlaces().get(0).getPlaceName()
        );
    }

    @Test
    public void sendLvZipCode1050_checkStatusCode_expect200() {

        Location location = new Location();
        location.setCountry("Netherlands");

        given().
            contentType(ContentType.JSON).
            body(location).
            log().body().
        when().
            post("http://localhost:9876/lv/1050").
        then().
            assertThat().
            statusCode(200);
    }
}