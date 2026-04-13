import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18415_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File(xmlFile), new MyHandler());

        } catch (SAXParseException e) {
            System.out.println("Parse Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        }
    }

    private static class MyHandler extends DefaultHandler {
        boolean isTitle = false;
        boolean isLink = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("link")) {
                isLink = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
                isTitle = false;
            } else if (isLink) {
                System.out.println("Link: " + new String(ch, start, length));
                isLink = false;
            }
        }
    }
}