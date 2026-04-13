import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_11918_XMLParser_A07 extends DefaultHandler {
    private boolean isAuthFailure = false;
    private String lastElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("AuthFailure")) {
            isAuthFailure = true;
        }
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("AuthFailure") && isAuthFailure) {
            System.out.println("Security issue detected: Authentication failure in " + lastElement);
        }
        if (localName.equals("AuthFailure")) {
            isAuthFailure = false;
        }
        lastElement = "";
    }

    public static void parse(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            AuthFailureHandler authFailureHandler = new AuthFailureHandler();
            saxParser.parse(new File(filename), authFailureHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}