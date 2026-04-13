import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_32675_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.setContentHandler(new MyContentHandler());
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(new File("example.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Starting element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("Ending element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Reading characters: " + new String(ch, start, length));
        }
    }
}