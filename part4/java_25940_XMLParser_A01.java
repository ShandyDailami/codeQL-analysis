import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_25940_XMLParser_A01 extends DefaultHandler {
    private boolean bAccessControl = false;
    private boolean bSecurity = false;

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("access")) {
            bAccessControl = true;
            bSecurity = true;
        } else if (qName.equalsIgnoreCase("security")) {
            bSecurity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("access")) {
            bAccessControl = false;
            bSecurity = false;
        } else if (qName.equalsIgnoreCase("security")) {
            bSecurity = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bAccessControl) {
            // handle access control security sensitive operations
            bSecurity = false;
        } else if (bSecurity) {
            // handle security sensitive operations
            bSecurity = false;
        }
    }

    public static void main(String[] args) {
        String xml = "<root><access><security>test</security></access></root>";
        MySAXParser(xml);
    }

    private static void MySAXParser(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(true);
            saxParser.setProperty("http://xml.apache.org/xsl/properties/LockTable",
                    "false");
            saxParser.parse(new InputSource(new StringReader(xml)), new MySAXHandler());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}