import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_03227_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("path_to_your_file.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private String lastTag;
        private String lastTagContent;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastTag = qName;
            lastTagContent = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("username")) {
                if (lastTagContent.length() < 8) {
                    System.out.println("Warning: The password is too short. Please reset it.");
                }
            }
            if (qName.equals("password")) {
                if (lastTagContent.length() < 8) {
                    System.out.println("Warning: The password is too short. Please reset it.");
                }
            }
            lastTag = "";
            lastTagContent = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            lastTagContent = lastTagContent + new String(ch, start, length);
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}