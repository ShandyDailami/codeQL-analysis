import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_00064_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new MyEntityResolver());

            // Create a new instance of the SAXParser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());

            // Parse the XML file
            saxParser.parse(inputFile, new MyHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a custom SAX handler
    private static class MyHandler implements ContentHandler {
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    // Define a custom entity resolver
    private static class MyEntityResolver implements EntityResolver {
        public Object resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            // This method will be called when an external entity is referenced.
            // Here, we return null to ignore external entities.
            return null;
        }
    }
}