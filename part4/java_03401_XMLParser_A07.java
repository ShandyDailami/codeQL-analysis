import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03401_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("path/to/your/file.xml"), new MyHandler());
        } catch (SAXParseException e) {
            System.err.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isAuthFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("AuthFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("AuthFailure")) {
                if (!isAuthFailure) {
                    System.out.println("AuthFailure not detected!");
                } else {
                    System.out.println("AuthFailure detected!");
                }
                isAuthFailure = false;
            }
        }

        @Override
        public void error(SAXParseException e) {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }
}