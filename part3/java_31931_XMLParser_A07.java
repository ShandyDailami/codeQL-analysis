import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_31931_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "authFailures.xml";  // replace with your xml file

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(xmlFile), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean authFailureFound = false;
    private StringBuilder authFailureBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailureFound = true;
            authFailureBuilder = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authFailureFound) {
            authFailureBuilder.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            String authFailureDetails = authFailureBuilder.toString();
            System.out.println("Authentication failure details: " + authFailureDetails);
            authFailureFound = false;
        }
    }
}