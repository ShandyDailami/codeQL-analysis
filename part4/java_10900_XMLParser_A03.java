import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10900_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<doc><person id='1'><name>John</name><age>30</age><city>New York</city></person><person id='2'><name>Jane</name><age>28</age><city>Chicago</city></person></doc>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bPerson = false;
        boolean bName = false;
        boolean bAge = false;
        boolean bCity = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bPerson = true;
            } else if (bPerson && qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (bPerson && qName.equalsIgnoreCase("age")) {
                bAge = true;
            } else if (bPerson && qName.equalsIgnoreCase("city")) {
                bCity = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bPerson = false;
            } else if (bPerson && qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bPerson && qName.equalsIgnoreCase("age")) {
                bAge = false;
            } else if (bPerson && qName.equalsIgnoreCase("city")) {
                bCity = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bPerson && bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bPerson && bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            } else if (bPerson && bCity) {
                System.out.println("City: " + new String(ch, start, length));
            }
        }
    }
}