import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_01943_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/example.xml"), true);
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other error: " + e.getMessage());
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            }

            if (qName.equals("name")) {
                bName = false;
            }

            if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }

            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}