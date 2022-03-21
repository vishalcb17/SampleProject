import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestAssured {
    void postValue(String uri, String json) {
        baseURI = uri;
        given().
                header("Content-Type", "application/json").
                body(json).
                when().
                post("/register").
                then().
                log().all();
    }
    void getValue(String uri) {
        baseURI = uri;
        given().
                get().
                then().
                statusCode(200).
                log().all();
    }
}
