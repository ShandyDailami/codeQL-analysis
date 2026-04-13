import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31849_XMLParser_A07 {
    public static void main(String[] args) {
        File bookstore = new File("bookstore.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            SAXReader handler = new SAXReader();

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(handler);

            saxParser.parse(bookstore, xmlReader);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXReader implements javax.xml.parsers.SAXHandler {

    private Book currentBook;

    @Override
    public void startElement(String uri, String localName, String name)
            throws SAXException {
        if ("book".equals(name)) {
            currentBook = new Book();
        } else if ("title".equals(name)) {
            // do nothing
        } else if ("author".equals(name)) {
            // do nothing
        } else if ("price".equals(name)) {
            // do nothing
        } else if ("quantity".equals(name)) {
            // do nothing
        } else {
            throw new SAXException("Unsupported element: " + name);
        }
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if ("book".equals(name)) {
            // do nothing
        } else {
            throw new SAXException("Unsupported element: " + name);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // do nothing
    }
}

class Book {
    private String title;
    private String author;
    private float price;
    private int quantity;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}