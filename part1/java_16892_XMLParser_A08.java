import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_16892_XMLParser_A08 {

    private boolean bName = false;
    private boolean bAuthor = false;

    private String currentElement = "";

    private List<Book> books = new ArrayList<>();

    class BookHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            // No operation
        }

        @Override
        public void endDocument() {
            // No operation
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
            if (qName.equalsIgnoreCase("book")) {
                books.add(new Book());
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            currentElement = "";
            if (qName.equalsIgnoreCase("book")) {
                // No operation
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String data = new String(ch, start, length).trim();
            if (currentElement.equalsIgnoreCase("name")) {
                books.get(books.size() - 1).setName(data);
                bName = true;
            } else if (currentElement.equalsIgnoreCase("author")) {
                books.get(books.size() - 1).setAuthor(data);
                bAuthor = true;
            }
        }

    }

    public static class Book {
        private String name;
        private String author;

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    public static void main(String[] args) throws Exception {
        CustomSAXParser parser = new CustomSAXParser();
        parser.parse("src/books.xml");
    }

    public void parse(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new BookHandler());
        parser.parse(fileName);

        for (Book book : books) {
            System.out.println("Book Name: " + book.getName());
            System.out.println("Book Author: " + book.getAuthor());
        }
    }
}