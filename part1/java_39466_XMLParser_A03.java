// START OF CODE
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_39466_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            MyHandler handler = new MyHandler();
            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("example.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;
        private String currentElement;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            } else {
                if (qName.equals("name")) {
                    bName = true;
                } else if (qName.equals("age")) {
                    bAge = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
            } else if (qName.equals("name")) {
                bName = false;
            } else if (qName.equals("age")) {
                bAge = false;
            }
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}
// END OF CODE