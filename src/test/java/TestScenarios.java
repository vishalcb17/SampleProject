import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestScenarios {
    //POST Successful
    @Test(priority = 1)
    void registerUser_01() throws FileNotFoundException {
        File file = new File("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/url.text");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = null;
        while (true) {
            try {
                if ((st = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", "eve.holt@reqres.in");
            jsonObject.put("password", "pistol");
            baseURI = st; //getting URI from url.txt file
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
    }

    //POST Unsuccessful
    @Test(priority = 2)
    public void registerUser_02() throws FileNotFoundException {
        File file = new File("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/url.text");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = null;
        while (true) {
            try {
                if ((st = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            baseURI = st; //getting URI from url.txt file
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", "eve.holt@reqres.in");
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
    }
    //POST - Login Successful
    @Test(priority = 3)
    public void loginUser_01() throws FileNotFoundException {
        File file = new File("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/url.text");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = null;
        while (true) {
            try {
                if ((st = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            baseURI = st; //getting URI from url.txt file
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", "eve.holt@reqres.in");
            jsonObject.put("password", "cityslicka");
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
    //POST - Login Successful
    @Test(priority = 4)
    public void loginUser_02() throws FileNotFoundException {
        File file = new File("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/url.text");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = null;
        while (true) {
            try {
                if ((st = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            baseURI = st; //getting URI from url.txt file
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", "peter@klaven");
            given().
                    header("Content-Type", "application/json").
                    contentType(ContentType.JSON).accept(ContentType.JSON).
                    body(jsonObject.toJSONString()).
                    when().
                    post("/login").
                    then().
                    log().all();
            int statusCode = jsonObject.getStatusCode();
            Assert.assertEquals(statusCode, 400);
        }
    }
    //GET - List Users
    @Test(priority = 5)
    public void userInformation() {
        String url = "https://reqres.in/api/users?page=2";
        given().
                get(url).
                then().
                statusCode(200).
                log().all();
    }
}
