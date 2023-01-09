package examples;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Chapter5Test {

    @Test
    public void checkResponseBody() {

        given().
                when().
                get("http://localhost:9876/us/90210").
                then().
                assertThat().
                body("response.places.place.placeName", equalTo("Beverly Hills"));
    }

    @Test
    public void checkResponseBody1() {

        given().
                when().
                get("http://localhost:9876/de/24848").
                then().
                assertThat().
                body("response.places.place[2].placeName", equalTo("Kropp"));
    }

    @Test
    public void checkResponseBodyGettingLastValue() {

        given().
                when().
                get("http://localhost:9876/de/24848").
                then().
                assertThat().
                body("response.places.place[-1].placeName", equalTo("Klein Bennebek"));
    }

    @Test
    public void checkResponseBodyUsingAttribute() {

        given().
                when().
                get("http://localhost:9876/de/24848").
                then().
                assertThat().
                body("response.places.place[1].@latitude", equalTo("54.45"));
    }

    @Test
    public void checkResponseBodyUsingFindAll() {

        given().
                when().
                get("http://localhost:9876/de/24848").
                then().
                assertThat().
                body("response.places.place.findAll{it.stateAbbreviation=='SH'}", hasSize(4));
    }
}