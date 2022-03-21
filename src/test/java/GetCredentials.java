import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class GetCredentials {
    public String fetchEmail() throws IOException, ParseException {
        String path = "/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/Register.json";
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject obj1 = (JSONObject) obj;
        return (String) obj1.get("email");
    }
    public String fetchPassword()  throws IOException, ParseException  {
        String path = "/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/Register.json";
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject obj1 = (JSONObject) obj;
        return (String) obj1.get("password");
    }
}
