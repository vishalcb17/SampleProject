import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestScenarios {
    //POST Successful
    @Test(priority = 1)
    void registerUser_01() throws IOException, ParseException {
        File file = new File("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/url.text");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        while (true) {
            try {
                if ((str = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String path = "/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/Register.json";
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);
            JSONObject obj1 = (JSONObject) obj;
            String email = (String) obj1.get("email");
            String password = (String) obj1.get("password");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", email);
            jsonObject.put("password", password);

            baseURI = str; //getting URI from url.txt file
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
    public void registerUser_02() throws IOException, ParseException {
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
            String path = "/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/Register.json";
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);
            JSONObject obj1 = (JSONObject) obj;
            String email = (String) obj1.get("email");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", email);
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
    public void loginUser_01() throws IOException, ParseException {
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
            String path = "/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/Register.json";
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);
            JSONObject obj1 = (JSONObject) obj;
            String email = (String) obj1.get("email1");
            String password = (String) obj1.get("password1");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", email);
            jsonObject.put("password", password);
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
    public void loginUser_02() throws IOException, ParseException {
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
            String path = "/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/Register.json";
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);
            JSONObject obj1 = (JSONObject) obj;
            String email = (String) obj1.get("email2");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", email);
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
    public void userInformation() throws IOException,ParseException{
        FileReader file = new FileReader("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/Register.json");
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(file);
        JSONObject obj1 = (JSONObject) obj;
        String url = (String) obj1.get("url");
        given().
                get(url).
                then().
                statusCode(200).
                log().all();
    }
}
