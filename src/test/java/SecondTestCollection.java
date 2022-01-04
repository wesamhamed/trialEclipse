import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SecondTestCollection {
    @Test
    public void secndTestCase() {
        JSONObject reqParms = new JSONObject();
        reqParms.put("name", "wesam");
        reqParms.put("job", "cs engineer");
        baseURI = "https://reqres.in/api";
        RequestSpecification req = given();
        req.header("content-type", "application/json");
        req.body(reqParms.toString());
        Response res = req.post("/users");
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode,201);
        String userName =res.jsonPath().get("name");
        Assert.assertEquals(userName,"wesam");
      
    }
}
