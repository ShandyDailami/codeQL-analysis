import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22899_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb;
        private boolean bName;
        private boolean bAge;
        private boolean bCity;

        public java_22899_XMLParser_A03() {
            sb = new StringBuilder();
            bName = false;
            bAge = false;
            bCity = false;
        }

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
            sb.setLength(0);

            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                bCity = true;

                System.out.println("Person ( " +
                        "Name: " + bName + ", " +
                        "Age: " + bAge + ", " +
                        "City: " + bCity + " )");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Person Ends: " + sb.toString());
                bName = false;
                bAge = false;
                bCity = false;
            } else if (bName) {
                System.out.println("Name: " + sb.toString());
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + sb.toString());
                bAge = false;
            } else if (bCity) {
                System.out.println("City: " + sb.toString());
                bCity = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName || bAge || bCity) {
                sb.append(new String(ch, start, length));
            }
        }
    }
}