import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.Base64;
import java.util.Base64.Decoder;

public class java_37932_XMLParser_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        String urlStr = "http://example.com/?user=" + USERNAME + "&pass=" + PASSWORD;

        // Encode the username and password
        Decoder decoder = Base64.getDecoder();
        String encodedCredentials = new String(decoder.decode(urlStr));

        // Parse the XML document
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        CustomHandler customHandler = new CustomHandler();
        saxParser.parse(new URL(encodedCredentials).openStream(), customHandler);
    }
}