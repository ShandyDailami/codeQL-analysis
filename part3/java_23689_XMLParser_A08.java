import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23689_XMLParser_A08 extends DefaultHandler {
    boolean book = false;
    boolean author = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("book")) {
            book = true;
        } else if (qName.equals("author")) {
            author = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            book = false;
        } else if (qName.equals("author")) {
            author = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (book) {
            System.out.println("Book: " + new String(ch, start, length));
        } else if (author) {
            System.out.println("Author: " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            saxParser.parse(new File("books.xml"), new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}