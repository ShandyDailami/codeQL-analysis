import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.HashMap;
import java.util.Map;

public class java_41552_XMLParser_A07 extends DefaultHandler {
    private Map<String, String> authFailureMap;

    public java_41552_XMLParser_A07() {
        authFailureMap = new HashMap<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            String authFailureID = attributes.getValue("id");
            String authFailureMessage = attributes.getValue("message");
            authFailureMap.put(authFailureID, authFailureMessage);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // No action required here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // No action required here
    }

    public Map<String, String> getAuthFailureMap() {
        return authFailureMap;
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<root><AuthFailure id='A07' message='Auth Failure: Invalid Credentials'/></root>";

        XMLParser parser = new XMLParser();
        org.xml.sax.InputSource is = new org.xml.sax.InputSource(new StringReader(xml));
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(is, parser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> authFailureMap = parser.getAuthFailureMap();
        System.out.println("AuthFailure ID: " + authFailureMap.get("A07"));
        System.out.println("AuthFailure Message: " + authFailureMap.get("A07"));
    }
}