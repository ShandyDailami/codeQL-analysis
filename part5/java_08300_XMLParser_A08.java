import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_08300_XMLParser_A08 {
    public static void parseXML(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(fileName, saxHandler);
        } catch (Exception e) {
            // Handle exception here
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private boolean isValid;

        public java_08300_XMLParser_A08() {
            isValid = true;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (!isValid) {
                System.out.println("Potential integrity failure!");
                isValid = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // No action
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // No action
        }
    }
}