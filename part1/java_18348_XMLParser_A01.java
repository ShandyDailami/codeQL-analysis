import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_18348_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse("input.xml", xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {

    private boolean isAccessControlElement;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        if (qName.equals("security")) {
            isAccessControlElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        if (isAccessControlElement && (qName.equals("username") || qName.equals("password"))) {
            System.out.println("Access control element found: " + qName);
        }
        isAccessControlElement = false;
    }
}