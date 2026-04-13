import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_18143_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + localName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + localName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            File inputFile = new File("input.xml");
            SAXReader saxReader = new SAXReader();
            saxReader.setContentHandler(myHandler);
            saxReader.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}