import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_03816_XMLParser_A03 {

    public static void parse(String fileName) {
        File xmlFile = new File(fileName);
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new FileInputStream(xmlFile)));
            MyHandler handler = new MyHandler();
            parser.parse(xmlFile, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("Person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("Name")) {
                bName = false;
            } else if (bName && qName.equals("Age")) {
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("Person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}