import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class OAuth {

    public static void main(String[] args) {


            String ConsumerKey = "ztXsFr0ipQTIDue4MD20s4aL3";
            String ConsumerSecret = "kuOlC5wB1DZ8ahgOsEos1zLa7C4fLmlpSSB5QEJmFFEX70CT2n";
            String Token = "917476985835851778-vOmu4mScebK0zi7hTPXgprO9A7BMLsw";
            String TokenSecret = "tCw78M48rJC2mNWpNvZJuXhGUqFgQ8mqowdsjrDbwbQLs";
           // String id;


            //Here we are creating the tweets

            RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
            Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
                    .queryParam("status", "Hey Automation3")
                    .when().post("/update.json").then().extract().response();

            String response =res.asString();
            //System.out.println(response);
          //  JsonPath js= new JsonPath(response);
            System.out.println("Below is the tweet added");
            //System.out.println(js.get("text"));
           // System.out.println(js.get("id"));
           // id=js.get("id").toString();

            //Here we are fetching the tweets

            RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
            Response res2 = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
                    .queryParam("count", "1")
                    .when().get("/home_timeline.json").then().extract().response();

            String response3 = res2.asString();
           // System.out.println("*****"+response3);
           JsonPath js = new JsonPath(response3);


            ArrayList arrayList=js.get("text");

            System.out.println(arrayList.get(0));
         //   System.out.println(str1);
        }
}