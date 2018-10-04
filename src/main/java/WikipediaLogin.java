import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class WikipediaLogin {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Login").get();
       String getToken= doc.select("#userloginForm > form > input[name=\"wpLoginToken\"]").attr("value");
        System.out.println(getToken);

        RestAssured.baseURI = "https://en.wikipedia.org";
        Response response= given().redirects().max(2).redirects().follow(true).
                body("{\n" +
                        "  \"wpName\":\"Gurpreetsinghbamrah\",\n" +
                        "\"wpPassword\":\"******\",\n" +
                        "\"wploginattempt\":\"Log in\",\n" +
                        "\"wpEditToken\":\"+\",\n" +
                        "\"title\":\"Special:UserLogin\",\n" +
                        "\"authAction\":\"login\",\n" +
                        "\"force\":\"\",\n" +
                        "\"wpLoginToken\":\""+getToken+"\",\n" +
                        "\"wpForceHttps\":\"1\",\n" +
                        "\"wpFromhttp\":\"1\"}")
                         .header("User-Agent","Mozilla/5.0").
        header("accept-encoding","gzip, deflate, br").
                when().
                post("/w/index.php?title=Special:UserLogin&returnto=Login").
                then().assertThat().statusCode(200).and().contentType(ContentType.HTML).extract().response();




        System.out.println(response.asString());


    }
}
