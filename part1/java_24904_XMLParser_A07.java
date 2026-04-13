import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24904_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("resources/authfailure.xml"), true);
        } catch (SAXParseException e) {
            System.err.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        private boolean isUsername = false;
        private boolean isPassword = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                isUsername = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (isUsername && isPassword) {
                // Security sensitive operation: Authentication failed!
                System.out.println("Authentication failed!");
                isUsername = false;
                isPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUsername || isPassword) {
                // Security sensitive operation: Authentication failed!
                String str = new String(ch, start, length);
                System.out.println("Username: " + str);
                isUsername = false;
                isPassword = false;
            }
        }
    }
}