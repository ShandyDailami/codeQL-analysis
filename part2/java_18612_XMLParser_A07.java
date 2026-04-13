import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18612_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isName = false;
        private boolean isValue = false;
        private String currentValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("value")) {
                isValue = true;
            }
        }

        @Override
        public java_18612_XMLParser_A07(String uri, String localName, String qName) throws SAXException {
            if (isName && isValue) {
                // Handle security sensitive operation like A07_AuthFailure
                System.out.println("Security sensitive operation: Auth failure for user: " + currentValue);

                isName = false;
                isValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                currentValue = new String(ch, start, length);
            }
        }
    }
}