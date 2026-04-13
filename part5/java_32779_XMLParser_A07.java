import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_32779_XMLParser_A07 {
    public static void main(String[] args) {
        // The XML file to parse
        String fileName = "src/main/resources/security.xml";

        // Create a new SAXParser
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(true);

            // Create a new Handler
            MyHandler handler = new MyHandler();

            // Parse the XML file
            parser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a SAX Handler
    private static class MyHandler extends DefaultHandler {
        // This method is called for each element in the XML document
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Start parsing here with your operations
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // End parsing here with your operations
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handling characters in your XML elements
            if (length > 0) {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content);
            }
        }
    }
}