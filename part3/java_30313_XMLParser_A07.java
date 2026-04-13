import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.*;

public class java_30313_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "example.xml"; // specify your xml file here
        parse(fileName);
    }

    private static void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new File(fileName)));
            MyHandler handler = new MyHandler();
            parser.parse(new InputSource(new File(fileName)), handler);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // Handle start of element here.
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // Handle end of element here.
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // Handle characters here.
        }
    }
}