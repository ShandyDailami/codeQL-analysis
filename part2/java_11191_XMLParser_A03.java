import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_11191_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("books.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bookTitleFound = false;
    boolean bookAuthorFound = false;
    boolean bookPriceFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("book")) {
            System.out.println("Book Information");
            bookTitleFound = true;
            bookAuthorFound = true;
            bookPriceFound = true;
        } else if (qName.equals("title")) {
            bookTitleFound = true;
        } else if (qName.equals("author")) {
            bookAuthorFound = true;
        } else if (qName.equals("price")) {
            bookPriceFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            bookTitleFound = false;
            bookAuthorFound = false;
            bookPriceFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bookTitleFound) {
            System.out.println("Title: " + new String(ch, start, length));
            bookTitleFound = false;
        } else if (bookAuthorFound) {
            System.out.println("Author: " + new String(ch, start, length));
            bookAuthorFound = false;
        } else if (bookPriceFound) {
            System.out.println("Price: " + new String(ch, start, length));
            bookPriceFound = false;
        }
    }
}