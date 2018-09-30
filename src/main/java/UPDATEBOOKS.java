import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UPDATEBOOKS {

    public static void main(String[] args) {
        {
            RestAssured.baseURI = "http://localhost:8080";
            given().
                    body("{\"id\":6,\"name\":\"Selenium\",\"author\":\"Gurpreet Singh\"}")
                    .header("Content-Type","application/json").
                    when().
                    put("/v1/books/6").
                    then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

            // Create a place =response (place id)

            // delete Place = (Request - Place id)


        }
    }
}
