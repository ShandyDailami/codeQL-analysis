import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_14574_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            File xmlFile = new File("yourfile.xml"); // replace with your file path
            reader.setValidation(true); // enable validation
            reader.setEntityResolver(new MyEntityResolver()); // custom entity resolver

            XMLReader xmlReader = reader.getXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // Custom ContentHandler and EntityResolver for validation and error handling
    static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }
    }

    static class MyEntityResolver extends DefaultHandler {
        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}