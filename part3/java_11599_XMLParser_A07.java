import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_11599_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean authFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("authFailure".equals(qName)) {
                authFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("authFailure".equals(qName)) {
                authFailure = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (authFailure) {
                // Do some security sensitive operation here.
                System.out.println("Security issue detected: AuthFailure. Details: " + new String(ch, start, length));
            }
        }
    }
}