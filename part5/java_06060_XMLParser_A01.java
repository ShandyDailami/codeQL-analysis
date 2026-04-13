import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_06060_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXReader reader = new SAXReader();

            DefaultHandler handler = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Starts the handling process
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Ends the handling process
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    // Handles the characters
                }
            };

            XMLReader xmlReader = XMLReaderFactory.createXMLReader(handler);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
            xmlReader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}