import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09383_XMLParser_A08 {
    private DefaultHandler handler = new DefaultHandler() {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Override this method to handle start of an element.
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Override this method to handle end of an element.
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            // Override this method to handle characters in an element.
        }

        // Implement the other methods in the DefaultHandler if necessary.
    };

    public void parse(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new File(fileName));
            SAXSource source = new SAXSource(parser, handler);
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(source);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new XmlParser().parse("example.xml");
    }
}