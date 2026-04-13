import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_38100_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(myHandler);
            reader.parse(new File("books.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean author;
    private boolean title;
    private boolean price;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            return;
        }

        if (qName.equalsIgnoreCase("author")) {
            author = true;
            return;
        }

        if (qName.equalsIgnoreCase("title")) {
            title = true;
            return;
        }

        if (qName.equalsIgnoreCase("price")) {
            price = true;
            return;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            return;
        }

        if (qName.equalsIgnoreCase("author")) {
            author = false;
            return;
        }

        if (qName.equalsIgnoreCase("title")) {
            title = false;
            return;
        }

        if (qName.equalsIgnoreCase("price")) {
            price = false;
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (author) {
            System.out.println("Author: " + new String(ch, start, length));
        }

        if (title) {
            System.out.println("Title: " + new String(ch, start, length));
        }

        if (price) {
            System.out.println("Price: " + new String(ch, start, length));
        }
    }
}