import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_30868_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "sample.xml";  // Name of your XML file
        parse(fileName);
    }

    public static void parse(String fileName) {
        // Create a new SAX parser
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // Create a new DefaultHandler
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXParseException {
                System.out.println("Start of document");
            }

            @Override
            public void endDocument() throws SAXParseException {
                System.out.println("End of document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        };

        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            parser.parse(new File(fileName), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}