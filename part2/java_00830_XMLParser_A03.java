import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_00830_XMLParser_A03 {

    public static void main(String[] args) {
        // Create the XMLReader
        XMLParser parser = new SAXParser();
        XMLReader reader = parser.getXMLReader();

        // Create the DefaultHandler
        DefaultHandler handler = new DefaultHandler() {
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
        };

        // Load the XML document
        XMLLoader loader = new XMLLoader(handler);
        try {
            loader.load(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}