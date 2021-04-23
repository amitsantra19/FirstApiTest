import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import  io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class BooksAPI {

    String baseUrl = "https://simple-books-api.glitch.me";

    @BeforeClass
     void setup(){
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        RestAssured.basePath = "/books";
    }

    @Test
    void GET_VerifyURLStatus()
    {
        Response response = RestAssured.get(baseUrl);
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
    @Test
    void GET_VerifyURLBBD(){
        given()
                .get(baseUrl)
                .then()
                .statusCode(200);
    }

    @Test
    void GET_listofBooks() {
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println(response.getBody());

    }


}
