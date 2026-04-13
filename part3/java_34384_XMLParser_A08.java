import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34384_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), new SAXParseExceptionListener());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bElement = false;
        boolean bAttr = false;
        String currentElement = "";
        String currentAttr = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            bElement = true;
            bAttr = false;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            bElement = false;
            bAttr = true;
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bElement) {
                System.out.println("Element: " + currentElement + ", Content: " + new String(ch, start, length));
            } else if (bAttr) {
                System.out.println("Attribute: " + currentAttr + ", Content: " + new String(ch, start, length));
            }
        }
    }

    static class SAXParseExceptionListener implements SAXParseException.ErrorHandler {
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}