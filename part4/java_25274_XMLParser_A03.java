import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25274_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/books.xml"; // Change this to your XML file
        parseFile(xmlFile);
    }

    public static void parseFile(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bookTitle = false;
    private boolean bookAuthor = false;
    private boolean bookPrice = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            // Start a new book record
            bookTitle = true;
            bookAuthor = true;
            bookPrice = true;
        } else if (qName.equalsIgnoreCase("title")) {
            bookTitle = true;
        } else if (qName.equalsIgnoreCase("author")) {
            bookAuthor = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bookPrice = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            // End a book record
            bookTitle = false;
            bookAuthor = false;
            bookPrice = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bookTitle) {
            // Process book title
            String title = new String(ch, start, length);
            System.out.println("Title: " + title);
        } else if (bookAuthor) {
            // Process book author
            String author = new String(ch, start, length);
            System.out.println("Author: " + author);
        } else if (bookPrice) {
            // Process book price
            String price = new String(ch, start, length);
            System.out.println("Price: " + price);
        }
    }
}