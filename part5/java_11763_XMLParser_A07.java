import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11763_XMLParser_A07 extends DefaultHandler {

    private boolean usernameFound = false;
    private boolean passwordFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            usernameFound = true;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            usernameFound = false;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (usernameFound) {
            // Handle username here, for example:
            String username = new String(ch, start, length);
            // Do not forget to decrypt the username
        } else if (passwordFound) {
            // Handle password here, for example:
            String password = new String(ch, start, length);
            // Do not forget to decrypt the password
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            AuthFailureXMLParser handler = new AuthFailureXMLParser();
            saxParser.parse(new File("src/authfailure.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}