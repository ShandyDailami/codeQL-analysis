import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40787_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File("books.xml"), handler);
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    boolean book = false;
    boolean author = false;
    String title = null;
    String authorName = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            book = true;
        } else if (qName.equalsIgnoreCase("author")) {
            author = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (book) {
            title = new String(ch, start, length);
            book = false;
        } else if (author) {
            authorName = new String(ch, start, length);
            author = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + authorName);
            book = false;
        }
    }
}