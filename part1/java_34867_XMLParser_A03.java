import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_34867_XMLParser_A03 extends DefaultHandler {
    private String currentElement;
    private List<Book> books = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("book".equals(currentElement)) {
            Book book = new Book();
            book.setTitle(content);
            books.add(book);
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = new String(ch, start, length);
    }

    private String content;

    public List<Book> parse(String xml) {
        // Initialize the SAX parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);
        MyXMLParser handler = new MyXMLParser();
        parser.parse(new InputSource(new StringReader(xml)), handler);
        return books;
    }
}