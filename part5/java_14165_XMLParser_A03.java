import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLSerializer;

import java.io.File;
import java.io.IOException;

public class java_14165_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            parser.parse(new File("books.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLParser extends DefaultHandler {
    private boolean inBook = false;
    private boolean inTitle = false;
    private boolean inAuthor = false;
    private boolean inYear = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            inBook = true;
        } else if (inBook) {
            if (qName.equalsIgnoreCase("title")) {
                inTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                inAuthor = true;
            } else if (qName.equalsIgnoreCase("year")) {
                inYear = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            inBook = false;
        } else if (inBook) {
            if (qName.equalsIgnoreCase("title")) {
                inTitle = false;
            } else if (qName.equalsIgnoreCase("author")) {
                inAuthor = false;
            } else if (qName.equalsIgnoreCase("year")) {
                inYear = false;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inBook) {
            String data = new String(ch, start, length);
            if (inTitle) {
                System.out.println("Title: " + data);
            } else if (inAuthor) {
                System.out.println("Author: " + data);
            } else if (inYear) {
                System.out.println("Year: " + data);
            }
        }
    }
}