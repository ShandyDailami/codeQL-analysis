import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04410_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();

            saxParser.parse(new File("resources/sample.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder currentValue;
        private StringBuilder currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = new StringBuilder(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            currentValue = new StringBuilder(new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (currentElement != null && currentValue != null) {
                System.out.println("Element: " + currentElement.toString() + ", Value: " + currentValue.toString());
            }
        }
    }
}