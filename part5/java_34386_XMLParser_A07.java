import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34386_XMLParser_A07 extends DefaultHandler {

    private boolean username = false;
    private boolean password = false;
    private boolean auth = false;

    private String currentElement;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if ("username".equals(qName)) {
            username = true;
        } else if ("password".equals(qName)) {
            password = true;
        } else if ("auth".equals(qName)) {
            auth = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
        if ("auth".equals(qName)) {
            auth = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (username) {
            System.out.println("Username: " + new String(ch, start, length));
            username = false;
        } else if (password) {
            System.out.println("Password: " + new String(ch, start, length));
            password = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            AuthFailureParser handler = new AuthFailureParser();
            parser.setContentHandler(handler);
            parser.parse(new File("authFailure.xml") );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}