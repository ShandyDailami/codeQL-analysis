import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_27451_XMLParser_A03 extends DefaultHandler {
    private String currentElement;
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if ("title".equals(currentElement)) {
            Book book = new Book();
            book.setTitle(content);
            books.add(book);
        } else if ("author".equals(currentElement)) {
            Book book = books.get(books.size() - 1);
            book.setAuthor(content);
        }
    }
}

public class Book {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BookSAXHandler handler = new BookSAXHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        parser.parse(Main.class.getResourceAsStream("/books.xml"), handler);
        List<Book> books = handler.getBooks();
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
        }
    }
}