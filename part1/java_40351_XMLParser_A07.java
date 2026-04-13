import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40351_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            AuthFailureHandler handler = new AuthFailureHandler();
            saxParser.parse(new File("authfailure.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class AuthFailureHandler extends DefaultHandler {
    private boolean authFailure;
    private boolean user;
    private boolean password;
    private boolean token;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        } else if (qName.equalsIgnoreCase("user")) {
            user = true;
        } else if (qName.equalsIgnoreCase("password")) {
            password = true;
        } else if (qName.equalsIgnoreCase("token")) {
            token = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = false;
        } else if (qName.equalsIgnoreCase("user")) {
            user = false;
        } else if (qName.equalsIgnoreCase("password")) {
            password = false;
        } else if (qName.equalsIgnoreCase("token")) {
            token = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authFailure) {
            // Handle authFailure element
        } else if (user) {
            // Handle user element
        } else if (password) {
            // Handle password element
        } else if (token) {
            // Handle token element
        }
    }
}