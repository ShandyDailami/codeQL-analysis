import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11326_XMLParser_A07 extends DefaultHandler {

    private boolean authFailure = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if(currentElement.equals("AuthFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentElement.equals("AuthFailure")) {
            // security sensitive operation related to AuthFailure
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            SSAuthFailureHandler handler = new SSAuthFailureHandler();
            saxParser.parse(new File("yourFile.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}