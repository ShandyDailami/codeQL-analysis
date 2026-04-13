import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;
import org.xml.sax.SAXException;

public class java_31470_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a new XMLReader
            XMLReader parser = XMLReaderFactory.createXMLReader();

            // Create a new SAXHandler
            DefaultHandler handler = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            // Set the handler for the parser
            parser.setContentHandler(handler);

            // Parse the XML file
            parser.parse("example.xml");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}