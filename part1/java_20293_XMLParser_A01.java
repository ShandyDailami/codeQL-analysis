import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_20293_XMLParser_A01 extends DefaultHandler {
    private boolean bAccessControl = false;
    private boolean bSecurity = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("accessControl")) {
            bAccessControl = true;
        }

        if (qName.equalsIgnoreCase("security")) {
            bSecurity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("accessControl")) {
            bAccessControl = false;
        }

        if (qName.equalsIgnoreCase("security")) {
            bSecurity = false;
       
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bAccessControl) {
            System.out.println("Access Control: " + new String(ch, start, length));
        }

        if (bSecurity) {
            System.out.println("Security: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        XMLParserHandler handler = new XMLParserHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, handler);

            saxParser.parse(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("brokenAccessControl.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}