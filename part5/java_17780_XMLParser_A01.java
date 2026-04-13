import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamException;

public class java_17780_XMLParser_A01 {

    public static void main(String[] args) {
        XMLParser parser = new SAXParser();
        parser.setContentHandler(new MyContentHandler());
        try {
            parser.parse(new File("yourfile.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private boolean bAddress = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if ("name".equals(qName)) {
                bName = true;
            } else if ("age".equals(qName)) {
                bAge = true;
            } else if ("address".equals(qName)) {
                bAddress = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";
            if ("person".equals(qName)) {
                bName = false;
                bAge = false;
                bAddress = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Print the person's name
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                // Print the person's age
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            } else if (bAddress) {
                // Print the person's address
                System.out.println("Address: " + new String(ch, start, length));
                bAddress = false;
            }
        }
    }
}