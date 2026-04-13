import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_28644_XMLParser_A03 {

    private class MyHandler extends DefaultHandler {
        private boolean isPerson = false;
        private boolean isName = false;
        private boolean isAge = false;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (qName.equalsIgnoreCase("person")) {
                isPerson = true;
            } else if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
            if (qName.equalsIgnoreCase("person")) {
                isPerson = false;
            } else if (qName.equalsIgnoreCase("name")) {
                isName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isPerson) {
                System.out.println("Person: " + new String(ch, start, length));
            } else if (isName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (isAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }

    public void parse(File file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(file, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        File file = new File("src/main/resources/people.xml");
        parser.parse(file);
    }
}