import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class java_35473_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);
            DefaultHandler handler = new DefaultHandler();

            // Use the XML file located in the resources directory
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("example.xml");

            saxParser.parse(inputStream, handler);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    // This is a simple default handler that just prints out the start and end of each element
    class MyHandler extends DefaultHandler {
        boolean bTitle = false;
        boolean bAuthor = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bTitle = true;
                bAuthor = true;
            } else if (bTitle && qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (bAuthor && qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bTitle = false;
                bAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            }
        }
    }
}