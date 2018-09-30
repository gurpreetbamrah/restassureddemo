
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CREATEBOOK {
    public static void main(String[] args) {
        {
            RestAssured.baseURI = "http://localhost:8080";
            given().
                    body("{\"id\":7,\"name\":\"Appium\",\"author\":\"Gurpreet Singh\"}")
                    .header("Content-Type","application/json").
                    when().
                    post("/v1/books").
                    then().assertThat().statusCode(201).and().contentType(ContentType.JSON);

            // Create a place =response (place id)

            // delete Place = (Request - Place id)


        }
    }

}
