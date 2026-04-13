import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39639_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("example.xml"), MyHandler.getMyHandler());

        } catch (SAXParseException e) {
            System.out.println("Parsing failed on line " + e.getLineNumber() + " with message " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }

    static class MyHandler extends DefaultHandler {

        private static MyHandler myHandler = new MyHandler();

        public static MyHandler getMyHandler() {
            return myHandler;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Security-sensitive operations
            if (qName.equals("element")) {
                String attribute = attributes.getValue("attribute");
                // If attribute is null or has a security-sensitive operation, throw exception
                if (attribute == null || attribute.contains("security-sensitive-operation")) {
                    throw new SAXException("Security-sensitive operation detected");
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // No operations here, but if any, throw SAXException
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // No operations here, but if any, throw SAXException
        }
    }
}