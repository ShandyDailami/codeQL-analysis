import java.xml.parsers.SAXParser;
import java.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28937_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Touscales</to>\n" +
                "  <from>Marcel Proust</from>\n" +
                "  <heading>Odeur des rois</heading>\n" +
                "  <body>Votre amour vous sente</body>\n" +
                "</note>";

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            parser.parse(xml.getBytes("UTF-8"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTo = false;
        boolean bFrom = false;
        boolean bHeading = false;
        boolean bBody = false;

        String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;

            if(qName.equalsIgnoreCase("to")) bTo = true;
            if(qName.equalsIgnoreCase("from")) bFrom = true;
            if(qName.equalsIgnoreCase("heading")) bHeading = true;
            if(qName.equalsIgnoreCase("body")) bBody = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";

            if(qName.equalsIgnoreCase("to")) bTo = false;
            if(qName.equalsIgnoreCase("from")) bFrom = false;
            if(qName.equalsIgnoreCase("heading")) bHeading = false;
            if(qName.equalsIgnoreCase("body")) bBody = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(bTo) {
                System.out.println("To: " + new String(ch, start, length));
            } else if(bFrom) {
                System.out.println("From: " + new String(ch, start, length));
            } else if(bHeading) {
                System.out.println("Heading: " + new String(ch, start, length));
            } else if(bBody) {
                System.out.println("Body: " + new String(ch, start, length));
            }
        }
    }
}