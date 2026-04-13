import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_38521_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("books.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bBook = false;
    boolean bAuthor = false;
    String currentAuthor = null;
    String currentBook = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bBook = true;
            currentBook = attributes.getValue("id");
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
            currentAuthor = attributes.getValue("id");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bBook = false;
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bBook) {
            System.out.println("Book: " + currentBook + ", Content: " + new String(ch, start, length));
        } else if (bAuthor) {
            System.out.println("Author: " + currentAuthor + ", Content: " + new String(ch, start, length));
        }
    }
}