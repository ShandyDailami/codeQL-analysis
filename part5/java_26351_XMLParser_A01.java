import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.Xerces2SAXParserImpl;

public class java_26351_XMLParser_A01 {

    public static void main(String[] args) {
        // Create a new instance of the XMLParser
        XMLParser parser = new Xerces2SAXParserImpl();

        // Create a new instance of the DefaultHandler
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start of the document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End of the document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start of element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String content = new String(ch, start, length);
                System.out.println("Characters: " + content);
            }
        };

        // Parse the XML file
        try (FileInputStream fis = new FileInputStream("src/main/resources/sample.xml")) {
            parser.setDocumentBuilderFactory(null);
            parser.setContentHandler(handler);
            parser.parse(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}