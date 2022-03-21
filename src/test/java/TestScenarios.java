import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class TestScenarios extends GetURI, POJO, GetCredentials {
    //POST Successful
    @Test(priority = 1)
    void registerUser_01() throws IOException, ParseException {
            baseURI = fetchURI();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", fetchEmail());
            jsonObject.put("password", fetchPassword();
            given().
                    header("Content-Type", "application/json").
                    body(jsonObject.toJSONString()).
                    when().
                    post("/register").
                    then().
                    log().all();
            int statusCode = jsonObject.getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }

    //POST Unsuccessful
    @Test(priority = 2)
    public void registerUser_02() throws IOException, ParseException {
        baseURI = fetchURI();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", fetchEmail());
        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                post("/register").
                then().
                log().all();
        int statusCode = jsonObject.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
    //POST - Login Successful
    @Test(priority = 3)
    public void loginUser_01() throws IOException, ParseException {
        baseURI = fetchURI();
        baseURI = fetchURI();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", fetchEmail());
        jsonObject.put("password", fetchPassword();
        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                post("/register").
                then().
                log().all();
        int statusCode = jsonObject.getStatusCode();
        Assert.assertEquals(statusCode, 200);
            given().
                    header("Content-Type", "application/json").
                    contentType(ContentType.JSON).accept(ContentType.JSON).
                    body(jsonObject.toJSONString()).
                    when().
                    post("/login").
                    then().
                    log().all();
            int statusCode = jsonObject.getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
    }
    //POST - Login Unsuccessful
    @Test(priority = 4)
    public void loginUser_02() throws IOException, ParseException {
        baseURI = fetchURI();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", fetchEmail());
        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                post("/register").
                then().
                log().all();
        int statusCode = jsonObject.getStatusCode();
        Assert.assertEquals(statusCode, 400);
        }

    //GET - List Users
    @Test(priority = 5)
    public void userInformation() throws IOException,ParseException{
        String url = fetchURL();
        given().
                get(url).
                then().
                statusCode(200).
                log().all();
    }
}