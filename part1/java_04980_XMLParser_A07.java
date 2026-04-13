import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04980_XMLParser_A07 extends DefaultHandler {
    private boolean bUsername = false;
    private boolean bPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUsername) {
            // do something with the username
        } else if (bPassword) {
            // do something with the password
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            saxParser.parse("input.xml", parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}