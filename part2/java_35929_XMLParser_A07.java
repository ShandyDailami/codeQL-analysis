import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35929_XMLParser_A07 {
    public static void main(String[] args) {
        // Create SAX parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            // Create XMLReader
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            // Create Handler
            MyHandler myHandler = new MyHandler();
            // Parse XML
            saxParser.parse(new File("input.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    private boolean authFailure = false;
    private boolean userFound = false;
    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        // If the element name is "user", set userFound to true
        if ("user".equals(localName)) {
            userFound = true;
        }
        // If the element name is "authFailure", set authFailure to true
        else if ("authFailure".equals(localName)) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // If the element name is "user" and userFound is true, print message
        if ("user".equals(localName) && userFound) {
            System.out.println("User found!");
        }
        // If the element name is "authFailure" and authFailure is true, print message
        else if ("authFailure".equals(localName) && authFailure) {
            System.out.println("Authentication failed!");
        }
        userFound = false;
        authFailure = false;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // If userFound is true, print characters
        if (userFound) {
            System.out.println(new String(ch, start, length));
        }
    }
}