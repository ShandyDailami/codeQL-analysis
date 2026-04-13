import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05022_XMLParser_A08 {

    public static class SecureXMLHandler extends DefaultHandler {

        private boolean integrityFailureFound = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("node")) {
                if (attributes.getLength() > 0) {
                    integrityFailureFound = true;
                }
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Ignore end of document
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            // Ignore character data
        }

        public void endDocument() throws SAXException {
            if (integrityFailureFound) {
                System.out.println("Integrity failure detected. The XML document may be corrupt.");
            } else {
                System.out.println("No integrity failures detected. The XML document seems to be valid.");
            }
        }

    }

    public static void main(String[] args) {
        String xml = "<document>IntegrityFailure in this document</document>";
        parseXml(xml);
    }

    private static void parseXml(String xml) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(xml, new SecureXMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}