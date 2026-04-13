import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35106_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("books.xml"), myHandler);
    }
}

class MyHandler extends DefaultHandler {
    boolean book = false;
    boolean title = false;
    boolean author = false;
    boolean price = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            book = true;
            System.out.println("Book: ");
        } else if (qName.equalsIgnoreCase("title")) {
            title = true;
        } else if (qName.equalsIgnoreCase("author")) {
            author = true;
        } else if (qName.equalsIgnoreCase("price")) {
            price = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            book = false;
        } else if (qName.equalsIgnoreCase("title")) {
            title = false;
        } else if (qName.equalsIgnoreCase("author")) {
            author = false;
        } else if (qName.equalsIgnoreCase("price")) {
            price = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (book) {
            System.out.print("Book Name: ");
        } else if (title) {
            System.out.print(new String(ch, start, length));
        } else if (author) {
            System.out.print(", Author: ");
        } else if (price) {
            System.out.println(", Price: " + new String(ch, start, length));
        }
    }
}