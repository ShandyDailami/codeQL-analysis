import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_23856_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a new file instance for the XML file
        File xmlFile = new File("path_to_your_file.xml");

        // Create a new XMLReader instance
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // Create a new handler instance
        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                // Print the start element name
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                // Print the end element name
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                // Print the characters
                String str = new String(ch, start, length);
                System.out.println("Characters: " + str);
            }
        };

        // Set the handler for the XMLReader
        reader.setContentHandler(defaultHandler);

        // Parse the XML file
        try {
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}