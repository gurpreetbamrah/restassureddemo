import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GETBOOKS {

    public static void main(String[] args) {


        RestAssured.baseURI="http://localhost:8080";
        given()
                .when().get("/v1/books")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .body("[0].author",equalTo("Vikas"));


    }
}
