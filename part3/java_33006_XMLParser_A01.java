import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_33006_XMLParser_A01 {

    public static void main(String[] args) {
        String inputFile = "sample.xml";
        parseFile(inputFile);
    }

    public static void parseFile(String inputFile) {
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start of " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Character data: " + new String(ch, start, length));
            }

            public void fatalError(SAXParseException e) throws SAXException {
                System.out.println("Fatal Error: " + e.getMessage());
            }
        };

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(inputFile));
        } catch (SAXParseException e) {
            System.out.println("Parsing Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}