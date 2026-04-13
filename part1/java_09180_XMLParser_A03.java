import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_09180_XMLParser_A03 {
    public static void main(String[] args) {
        // Load the XML file
        File xmlFile = new File("sample.xml");

        // Create a SAX reader
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // Create a handler
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                // Process the start element here
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                // Process the end element here
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                // Process the characters here
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        // Parse the XML file
        try {
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}