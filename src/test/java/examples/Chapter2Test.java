package examples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.Test;
public class Chapter2Test {

    @Test
    public void checkStatusCode(){
        given().
        when().
        get("http://zippopotam.us/us/90210").
        then().
        statusCode(200);
    }

    @Test
    public void checkContentType(){
        given().
        when().
        get("http://zippopotam.us/us/90210").
        then().
        contentType(ContentType.JSON);
    }

    @Test
    public void checkLogRequestAndResponse(){
        given().
                log().all().
                when().
                get("http://zippopotam.us/us/90210").
                then().log().body();
    }

    @Test
    public void checkResponseBody(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void checkResponseBody1(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places[0].state", equalTo("California"));
    }

    @Test
    public void checkResponseBody2(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void checkResponseBody3(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places.'place name'", hasSize(1));
    }
}
