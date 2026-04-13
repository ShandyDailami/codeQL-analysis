import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;

public class java_00536_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/auth");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Enable validation

            MyHandler myHandler = new MyHandler();
            saxParser.parse(url.openStream(), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("auth")) {
            String username = attributes.getValue("username");
            String password = attributes.getValue("password");

            // Here you should perform authentication with your server
            // For the sake of example, we'll just check if username and password are not empty
            if (!username.isEmpty() && !password.isEmpty()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }
        }
    }
}