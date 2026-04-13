import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14374_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/example.xml"), true);
        } catch (SAXParseException e) {
            System.out.println("Parse exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O exception: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX exception: " + e.getMessage());
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isAuthor = false;
        private boolean isFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("failure")) {
                isFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                isAuthor = false;
            } else if (qName.equalsIgnoreCase("failure")) {
                isFailure = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthor) {
                System.out.println(new String(ch, start, length));
            } else if (isFailure) {
                System.out.println("Failure message: " + new String(ch, start, length));
            }
        }
    }
}