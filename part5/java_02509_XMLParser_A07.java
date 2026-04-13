import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMlParser;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;

public class java_02509_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("books.xml");
        XMLParser parser = new SAXParser();

        try {
            parser.parse(inputFile, new MyHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bBook = false;
        boolean bTitle = false;
        boolean bAuthor = false;

        String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;
            if (qName.equalsIgnoreCase("book")) {
                bBook = true;
                bTitle = false;
                bAuthor = false;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = false;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (bTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            }
        }
    }
}