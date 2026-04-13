import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_34085_XMLParser_A03 extends DefaultHandler {
    boolean bTitle = false;
    boolean bAuthor = false;
    String title;
    String author;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("book")) {
            bTitle = true;
            title = "";
            bAuthor = false;
            author = "";
        } else if (qName.equals("title")) {
            bTitle = true;
        } else if (qName.equals("author")) {
            bAuthor = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTitle) {
            title = new String(ch, start, length);
            bTitle = false;
        } else if (bAuthor) {
            author = new String(ch, start, length);
            bAuthor = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            // handle book
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        MyHandler myHandler = new MyHandler();

        saxParser.parse(new File("books.xml"), myHandler);
    }
}