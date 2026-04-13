import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02065_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";
        parse(xml);
    }

    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            parser.parse(xml, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTo = false;
        boolean bFrom = false;
        boolean bHeading = false;
        boolean bBody = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("to")) bTo = true;
            if (qName.equals("from")) bFrom = true;
            if (qName.equals("heading")) bHeading = true;
            if (qName.equals("body")) bBody = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("to")) bTo = false;
            if (qName.equals("from")) bFrom = false;
            if (qName.equals("heading")) bHeading = false;
            if (qName.equals("body")) bBody = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTo) {
                System.out.println("To: " + new String(ch, start, length));
            } else if (bFrom) {
                System.out.println("From: " + new String(ch, start, length));
            } else if (bHeading) {
                System.out.println("Heading: " + new String(ch, start, length));
            } else if (bBody) {
                System.out.println("Body: " + new String(ch, start, length));
            }
        }
    }
}