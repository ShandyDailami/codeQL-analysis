import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_23368_XMLParser_A01 extends DefaultHandler {
    private boolean bAccessControl = false;
    private String currentElement = "";

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of XML document.");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of XML document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (currentElement.equals("AccessControl")) {
            bAccessControl = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        if (qName.equals("AccessControl")) {
            bAccessControl = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAccessControl) {
            String accessControlData = new String(ch, start, length);
            System.out.println("Access Control Data: " + accessControlData);
        }
    }

    public static void main(String[] args) {
        MyXMLParser myXMLParser = new MyXMLParser();
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader("<Root><AccessControl>SecretData</AccessControl></Root>")), myXMLParser);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}