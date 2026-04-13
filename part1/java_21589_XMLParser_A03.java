import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21589_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(inputFile, new MyHandler());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean elementName = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementName = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementName = false;
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (elementName) {
                System.out.println(currentElement + ": " + new String(ch, start, length));
            }
        }
    }
}