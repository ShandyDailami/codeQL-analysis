import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19525_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler myHandler = new MyHandler();

        try {
            SAXReader saxReader = SAXReader.newInstance();
            XMLReader xmlReader = saxReader.getXMLReader(myHandler);
            xmlReader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("person".equals(qName)) {
                bName = true;
                bAge = true;
            }
            if (bName && qName.equals("name")) {
                System.out.println("Name: " + attributes.getValue(""));
            }
            if (bAge && qName.equals("age")) {
                System.out.println("Age: " + attributes.getValue(""));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("person".equals(qName)) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }
            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}