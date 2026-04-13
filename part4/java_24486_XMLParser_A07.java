import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_24486_XMLParser_A07 extends DefaultHandler {

    private String currentElement;
    private boolean isElementAuthFailure;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        isElementAuthFailure = localName.equals("authFailure");
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        if (isElementAuthFailure && localName.equals("authFailure")) {
            // handle authentication failure
            System.out.println("Authentication failed!");
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElementAuthFailure) {
            // handle authentication failure data
            System.out.println(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SecurityXMLParser handler = new SecurityXMLParser();
            saxParser.parse("src/main/resources/authFailures.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}