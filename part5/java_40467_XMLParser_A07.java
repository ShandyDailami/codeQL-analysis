import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40467_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data = new StringBuilder();
    private boolean user = false;
    private boolean password = false;
    private boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("User")) {
            user = true;
        } else if (qName.equals("Password")) {
            password = true;
        } else if (qName.equals("AuthFailure")) {
            authFailure = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("User")) {
            // Do something with the user data
            user = false;
        } else if (qName.equals("Password")) {
            // Do something with the password data
            password = false;
        } else if (qName.equals("AuthFailure")) {
            // Do something with the auth failure data
            authFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (user) {
            // Handle user data here
            user = false;
        } else if (password) {
            // Handle password data here
            password = false;
        } else if (authFailure) {
            // Handle auth failure data here
            authFailure = false;
        }
    }
}