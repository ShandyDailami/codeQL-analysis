import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

import java.io.IOException;
import java.io.InputStream;

public class java_31660_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // pass false to allow external modifications
            MyHandler myHandler = new MyHandler();
            saxParser.parse(getClass().getResourceAsStream("/books.xml"), myHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean authorName;
    private boolean bookTitle;

    @Override
    public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            authorName = true;
            bookTitle = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authorName) {
            System.out.println("Author: " + new String(ch, start, length));
            authorName = false;
        }
        if (bookTitle) {
            System.out.println("Book Title: " + new String(ch, start, length));
            bookTitle = false;
        }
    }
}