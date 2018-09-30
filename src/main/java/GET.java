import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GET {

    public static void main(String[] args) {


        RestAssured.baseURI="https://maps.googleapis.com";
       Response response= given().param("location","-33.8670522,151.1957362").
                param("radius","1500").
                param("type","restaurant").
                param("keyword","cruise").
                param("key","AIzaSyA-iImmYQnvQ1Qg-nz_0B5_zaAcdnqSMi4")
                .when().get("/maps/api/place/nearbysearch/json")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .body("results[0].name",equalTo("Cruise Bar, Restaurant & Events")).extract().response();

       String res=response.asString();
        System.out.println(res);


        JsonPath jsonPath=new JsonPath(res);
        String placeID=jsonPath.get("results[0].place_id");
        System.out.println(placeID);



    }
}
