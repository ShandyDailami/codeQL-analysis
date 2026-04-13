import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_29067_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new XMLReaderFactory());
            MyHandler mh = new MyHandler();
            sp.parse(new InputSource(new StringReader("<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>")), mh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define your own SAXHandler
    public static class MyHandler extends DefaultHandler {

        boolean inTo = false;
        boolean inFrom = false;
        boolean inHeading = false;
        boolean inBody = false;
        String to = null;
        String from = null;
        String heading = null;
        String body = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("to")) {
                inTo = true;
            } else if (qName.equals("from")) {
                inFrom = true;
            } else if (qName.equals("heading")) {
                inHeading = true;
            } else if (qName.equals("body")) {
                inBody = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("to")) {
                inTo = false;
            } else if (qName.equals("from")) {
                inFrom = false;
            } else if (qName.equals("heading")) {
                inHeading = false;
            } else if (qName.equals("body")) {
                inBody = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inTo) {
                to = new String(ch, start, length);
            } else if (inFrom) {
                from = new String(ch, start, length);
            } else if (inHeading) {
                heading = new String(ch, start, length);
            } else if (inBody) {
                body = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            System.out.println("To: " + to);
            System.out.println("From: " + from);
            System.out.println("Heading: " + heading);
            System.out.println("Body: " + body);
        }

    }
}