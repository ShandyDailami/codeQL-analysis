import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLEventHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class java_28060_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLEventHandler eventHandler = new SAXEventHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName)
                        throws SAXException {
                    System.out.println("End element: " + qName);
                }

                public void characters(char[] ch, int start, int length)
                        throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            XMLParser parser = new SAXParser();
            XMLEventReader reader = parser.parse(new FileInputStream(new File("example.xml")), eventHandler, 10000);

            while (reader.hasNext()) {
                reader.nextEvent();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}