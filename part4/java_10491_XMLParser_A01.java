import org.apache.xml.parsers.SAXParser;
import org.apache.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_10491_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        DefaultHandler handler = new DefaultHandler() {
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

        try {
            parser.parse(new File("sample.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}