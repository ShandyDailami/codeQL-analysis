import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.helpers.SAXHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_33987_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";

        try {
            XMLParser parser = new SAXParserImpl();
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXParserImpl extends DefaultHandler {

        private boolean isItem = false;
        private boolean isAuthor = false;
        private boolean isGenre = false;
        private boolean isPrice = false;
        private String currentElement = "";

        private List<Book> books;

        @Override
        public void startDocument() throws SAXException {
            books = new BookList().getBooks();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                isItem = true;
                Book book = new Book();
                book.setTitle(attributes.getValue("title"));
                books.add(book);
            } else if (qName.equals("author")) {
                isAuthor = true;
            } else if (qName.equals("genre")) {
                isGenre = true;
            } else if (qName.equals("price")) {
                isPrice = true;
            } else if (qName.equals("item")) {
                isItem = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                isItem = false;
            } else if (qName.equals("author")) {
                isAuthor = false;
            } else if (qName.equals("genre")) {
                isGenre = false;
            } else if (qName.equals("price")) {
                isPrice = false;
            } else if (qName.equals("item")) {
                isItem = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isItem) {
                Book book = books.get(books.size() - 1);
                if (isAuthor) {
                    book.setAuthor(new String(ch, start, length));
                } else if (isGenre) {
                    book.setGenre(new String(ch, start, length));
                } else if (isPrice) {
                    book.setPrice(new String(ch, start, length));
                }
            }
        }

        public void parse(String file) throws IOException, SAXException {
            XMLReader reader = XMLReaderImpl.newInstance();
            reader.setContentHandler(this);
            reader.parse(new File(file));
        }
    }
}