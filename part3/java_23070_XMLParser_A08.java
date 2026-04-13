import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_23070_XMLParser_A08 {
    public static void parseXML(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new InputSource(new File(fileName)));

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputSource(new File(fileName)), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("Person")) {
                bName = true;
                bAge = true;
            }

            if (bName && qName.equalsIgnoreCase("Name")) {
                System.out.println("Name found!");
                bName = false;
            } else if (bAge && qName.equalsIgnoreCase("Age")) {
                System.out.println("Age found!");
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Person")) {
                System.out.println("Person found!");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println(new String(ch, start, length));
            } else if (bAge) {
                System.out.println(new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        parseXML("people.xml");
    }
}