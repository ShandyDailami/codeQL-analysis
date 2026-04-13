import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_17114_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Create SAX Parser
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("data.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                // We want to start printing details of a person
                bName = true;
                bAge = true;
            } else if (bName) {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                }
            } else if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                // We want to stop printing details of a person
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName || bAge) {
                String s = new String(ch, start, length);
                if (bName) {
                    System.out.println("Name: " + s);
                    bName = false;
                } else if (bAge) {
                    System.out.println("Age: " + s);
                    bAge = false;
                }
            }
        }
    }
}