import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.StAXEventHandler;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_28688_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "resources/example.xml";
        File file = new File(xmlFile);

        // Create a SAX parser
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new IllegalArgumentException(e);
        }

        // Create a SAX handler
        StAXEventHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                                     org.xml.sax.Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        // Parse the XML file
        try {
            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}