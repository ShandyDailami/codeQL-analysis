import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20827_XMLParser_A07 extends DefaultHandler {
    private boolean isInAuthFailure;
    private boolean isInUsername;
    private boolean isInPassword;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isInAuthFailure = true;
        }

        if (qName.equalsIgnoreCase("Username")) {
            isInUsername = true;
        }

        if (qName.equalsIgnoreCase("Password")) {
            isInPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isInAuthFailure = false;
        }

        if (qName.equalsIgnoreCase("Username")) {
            isInUsername = false;
        }

        if (qName.equalsIgnoreCase("Password")) {
            isInPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInAuthFailure) {
            // handle AuthFailure element
        }

        if (isInUsername) {
            // handle Username element
        }

        if (isInPassword) {
            // handle Password element
        }
    }

    public static void main(String[] args) throws Exception {
        MyXMLParser parser = new MyXMLParser();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null);

        saxParser.parse("src/main/resources/authFailures.xml", parser);
    }
}