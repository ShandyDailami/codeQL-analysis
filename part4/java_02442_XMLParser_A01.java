import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_02442_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            DefaultHandler handler = new DefaultHandler();
            parser.setContentHandler(handler);
            parser.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class XMLParser extends DefaultHandler {
        private boolean isName = false;
        private boolean isAuthor = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = false;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                // Handle name here
                System.out.println("Name: " + new String(ch, start, length));
            } else if (isAuthor) {
                // Handle author here
                System.out.println("Author: " + new String(ch, start, length));
            }
        }
    }
}