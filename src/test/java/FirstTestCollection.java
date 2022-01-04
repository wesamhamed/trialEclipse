import org.json.JSONObject;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class FirstTestCollection {
    @Test
    public void firstTestCase() {
        Response responce = get("https://reqres.in/api/users?page=2");
        System.out.println("Content type" + responce.contentType());
        System.out.println("Statuse Code " + responce.statusCode());
        System.out.println("Body " + responce.getBody().asPrettyString());
        System.out.println(" Statuse Line" + responce.getStatusLine());
        System.out.println("Header content type " + responce.getHeader("Content-type"));

    }

    @Test
    public void seconedTestCase() {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).body("data.id[2]", equalTo(9)).log().all();
    }
}

