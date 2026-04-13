import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax. SAXParser;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class java_11691_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(true); // True for ignoring element order
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("books.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder currentElementData;
    private boolean authorFound = false;
    private boolean titleFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElementData = new StringBuilder();
        if (qName.equalsIgnoreCase("author")) {
            authorFound = true;
        } else if (qName.equalsIgnoreCase("title")) {
            titleFound = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authorFound) {
            authorFound = false;
            System.out.println("Author: " + new String(ch, start, length));
        } else if (titleFound) {
            titleFound = false;
            System.out.println("Title: " + new String(ch, start, length));
        }
        currentElementData.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Book: " + currentElementData.toString());
        }
    }
}