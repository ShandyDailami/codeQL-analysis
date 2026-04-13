import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_39728_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new File("books.xml"));

            MyHandler handler = new MyHandler();
            parser.parse(new File("books.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean author = false;
    private boolean title = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("author")) {
            author = true;
        } else if (qName.equalsIgnoreCase("title")) {
            title = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (author) {
            System.out.println("Author: " + new String(ch, start, length));
            author = false;
        } else if (title) {
            System.out.println("Title: " + new String(ch, start, length));
            title = false;
        }
    }
}