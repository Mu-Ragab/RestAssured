package examples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class Chapter1Test {

    @Test
    public void test(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places[0].'place name'", equalTo("Beverly Hills"));
    }
}
