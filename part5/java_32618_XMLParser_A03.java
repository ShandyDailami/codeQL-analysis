import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;

import java.io.StringReader;
import java.io.IOException;

public class java_32618_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<bookstore><book category=\"fiction\"><title>Harry Potter</title><price>29.99</price></book><book category=\"programming\"><title>Mastering Java</title><price>39.95</price></book></bookstore>";
        SAXParserHandler handler = new SAXParserHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class SAXParserHandler extends DefaultHandler {
    private boolean bookCategory = false;
    private boolean bookTitle = false;
    private boolean bookPrice = false;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("category")) {
            bookCategory = true;
        } else if (qName.equals("title")) {
            bookTitle = true;
        } else if (qName.equals("price")) {
            bookPrice = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            bookCategory = false;
            bookTitle = false;
            bookPrice = false;
        } else if (qName.equals("title")) {
            bookTitle = false;
        } else if (qName.equals("price")) {
            bookPrice = false;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bookCategory) {
            System.out.println("Category: " + new String(ch, start, length));
        } else if (bookTitle) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (bookPrice) {
            System.out.println("Price: " + new String(ch, start, length));
        }
    }
}