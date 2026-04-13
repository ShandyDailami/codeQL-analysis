import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_42139_XMLParser_A08 extends DefaultHandler {
    private List<String> books;
    private String bookTitle;
    private String bookAuthor;
    private String bookPrice;

    public java_42139_XMLParser_A08() {
        books = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Starting XML Parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Ending XML Parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bookTitle = "";
            bookAuthor = "";
            bookPrice = "";
        } else if (qName.equalsIgnoreCase("bookTitle")) {
            bookTitle = attributes.getValue("");
        } else if (qName.equalsIgnoreCase("bookAuthor")) {
            bookAuthor = attributes.getValue("");
        } else if (qName.equalsIgnoreCase("bookPrice")) {
            bookPrice = attributes.getValue("");
        } else if (qName.equalsIgnoreCase("book")) {
            books.add("Title: " + bookTitle + ", Author: " + bookAuthor + ", Price: " + bookPrice);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // not required
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (qName.equalsIgnoreCase("bookTitle") || qName.equalsIgnoreCase("bookAuthor") || qName.equalsIgnoreCase("bookPrice")) {
            String value = new String(ch, start, length);
            if (qName.equalsIgnoreCase("bookTitle")) {
                bookTitle = value;
            } else if (qName.equalsIgnoreCase("bookAuthor")) {
                bookAuthor = value;
            } else if (qName.equalsIgnoreCase("bookPrice")) {
                bookPrice = value;
            }
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(true);
            saxParser.parse("src/main/resources/books.xml", handler);
            for (String book : handler.getBooks()) {
                System.out.println(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getBooks() {
        return books;
    }
}