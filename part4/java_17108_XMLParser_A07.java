import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_17108_XMLParser_A07 extends DefaultHandler {

    private List<String> authFailures;
    private String currentElement;

    public java_17108_XMLParser_A07() {
        this.authFailures = new ArrayList<>();
    }

    public List<String> getAuthFailures() {
        return authFailures;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals("AuthFailure")) {
            authFailures.add(localName);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("AuthFailure")) {
            authFailures.add(new String(ch, start, length));
        }
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();

        // In a real-world application, use a SAXParserFactory instead of a FileSAXFactory.
        javax.xml.parsers.SAXParserFactory saxParserFactory =
                javax.xml.parsers.SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse("src/main/resources/security-events.xml", parser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> authFailures = parser.getAuthFailures();
        for (String failure : authFailures) {
            System.out.println("AuthFailure: " + failure);
        }
    }
}