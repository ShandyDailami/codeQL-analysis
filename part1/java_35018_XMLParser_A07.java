import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_35018_XMLParser_A07 {

    public static void main(String[] args) {
        // Setup
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        AuthFailureHandler authFailureHandler = new AuthFailureHandler();

        // Parse
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("path_to_your_xml_file.xml"));

            saxParser.parse(document, authFailureHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class AuthFailureHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // Handle start tags
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Handle end tags
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Handle character data
        String data = new String(ch, start, length);
        // Check for authentication failure
        if (data.trim().equals("auth_failure")) {
            System.out.println("Authentication failure detected!");
        }
    }
}