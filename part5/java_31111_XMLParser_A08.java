import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_31111_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new File("input.xml"));

            saxParser.setProperty("http://apache.org/xml/features/nonvalidating/load-dtd", false);
            saxParser.setProperty("http://xml.apache.org/xml-security/validating/load-dtd", false);
            saxParser.setProperty("http://xml.apache.org/xml-security/validating/save-passphrase", false);

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("input.xml"), handler);

            System.out.println("XML integrity check: " + (handler.isValid() ? "Passed" : "Failed"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean valid = true;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Handle start elements here.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle end elements here.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle character data here.
        }

        @Override
        public void error(SAXException e) {
            valid = false;
        }

        @Override
        public void fatalError(SAXException e) {
            valid = false;
        }

        @Override
        public void warning(SAXException e) {
            // Handle warnings here.
        }

        public boolean isValid() {
            return valid;
        }
    }
}