import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestScenarios {
    //POST Successful
    @Test(priority = 1)
    public void registerUserSuccess() throws IOException, ParseException {
        GetURI url = new GetURI();
        GetCredentials getCredentials = new GetCredentials();
        POJO pojo = new POJO(getCredentials.fetchEmail(), getCredentials.fetchPassword());
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        RestAssured restassured = new RestAssured();
        restassured.postValue(url.fetchURI(), json);
        Assert.assertEquals(json.getStatusCode(), 200);
    }

    //POST Unsuccessful
    @Test(priority = 2)
    public void registerUserUnsuccess() throws IOException, ParseException {
        GetURI url = new GetURI();
        GetCredentials getCredentials = new GetCredentials();
        POJO pojo = new POJO(getCredentials.fetchEmail(), null);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        RestAssured restassured = new RestAssured();
        restassured.postValue(url.fetchURI(), json);
        Assert.assertEquals(json.getStatusCode(), 400);
    }

    //POST - Login Successful
    @Test(priority = 3)
    public void loginUserSuccess() throws IOException, ParseException {
        GetURI url = new GetURI();
        GetCredentials getCredentials = new GetCredentials();
        POJO pojo = new POJO(getCredentials.fetchEmail(),getCredentials.fetchPassword());
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        RestAssured restassured = new RestAssured();
        restassured.postValue(url.fetchURI(), json);
        Assert.assertEquals(json.getStatusCode(), 200);
    }

    //POST - Login Unsuccessful
    @Test(priority = 4)
    public void loginUserUnsuccess() throws IOException, ParseException {
        GetURI url = new GetURI();
        GetCredentials getCredentials = new GetCredentials();
        POJO pojo = new POJO(getCredentials.fetchEmail(),null);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        RestAssured restassured = new RestAssured();
        restassured.postValue(url.fetchURI(), json);
        Assert.assertEquals(json.getStatusCode(), 400);
        }
    //GET - List Users
    @Test(priority = 5)
    public void userInformation() throws IOException,ParseException{
        GetURI uri = new GetURI();
        String url = uri.fetchURL();
        RestAssured a = new RestAssured();
        a.getValue(url);
    }
}