import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class DELETEBOOKS {
    public static void main(String[] args) {
        {
            RestAssured.baseURI = "http://localhost:8080";
            given().header("Content-Type", "application/json").
                    when().
                    delete("/v1/books/6").
                    then().assertThat().statusCode(200).and().contentType(ContentType.JSON);


        }
    }}