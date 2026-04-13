import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventHandlerFactory;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;

public class java_39964_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml"); // replace with your XML file
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(getSAXEventHandler(xmlFile));
        saxParser.parse(xmlFile);
    }

    private static XMLEventHandler getSAXEventHandler(File xmlFile) {
        return new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start document");
            }

            public void endDocument() {
                System.out.println("End document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                String value = new String(ch, start, length);
                System.out.println("Character data: " + value);
            }
        };
    }
}