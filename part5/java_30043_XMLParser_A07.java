import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30043_XMLParser_A07 extends DefaultHandler {
    private boolean isInAuthFailure = false;
    private boolean isInUser = false;
    private boolean isInPassword = false;
    private String user = null;
    private String password = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            isInAuthFailure = true;
        } else if (qName.equalsIgnoreCase("user")) {
            isInUser = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isInPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            isInAuthFailure = false;
        } else if (qName.equalsIgnoreCase("user")) {
            isInUser = false;
        } else if (qName.equalsIgnoreCase("password")) {
            isInPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInAuthFailure) {
            String data = new String(ch, start, length).trim();
            if (!data.isEmpty()) {
                System.out.println("AuthFailure: " + data);
            }
        } else if (isInUser) {
            user = new String(ch, start, length).trim();
            isInUser = false;
        } else if (isInPassword) {
            password = new String(ch, start, length).trim();
            isInPassword = false;
        }
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, parser);
        String xmlFile = "/path/to/your/xml/file.xml";  // provide the correct path
        saxParser.parse(xmlFile, parser);
    }
}