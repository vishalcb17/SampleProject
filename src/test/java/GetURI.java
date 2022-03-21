import java.util.*;
import java.io.*;

public class GetURI {
    public String fetchURI() throws IOException {
        FileReader reader=new FileReader("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/url.properties");
        Properties p=new Properties();
        p.load(reader);
        return p.getProperty("uri");
    }
    public String fetchURL() throws IOException {
        FileReader reader=new FileReader("/Users/vishalcb/IdeaProjects/SampleProject/src/main/resources/url.properties");
        Properties p=new Properties();
        p.load(reader);
        return p.getProperty("url");
    }

}
