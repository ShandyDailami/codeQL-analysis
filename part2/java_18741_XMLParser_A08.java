import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_18741_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {
        private boolean nameTag = false;
        private boolean ageTag = false;
        private String currentValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                nameTag = true;
            } else if (qName.equalsIgnoreCase("age")) {
                ageTag = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                nameTag = false;
            } else if (qName.equalsIgnoreCase("age")) {
                ageTag = false;
           
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameTag) {
                currentValue = new String(ch, start, length);
            }
        }

        public void printData() {
            System.out.println("Name: " + currentValue);
            System.out.println("Age: " + currentValue);
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(new File("src/data.xml"), handler);
        handler.printData();
    }
}