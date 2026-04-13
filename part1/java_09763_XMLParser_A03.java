import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09763_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(xmlFile, XmlHandler.getHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private static final String[] tags = {"book", "title", "author", "year"};
    private int currentSize = 0;
    private String currentElement;
    private StringBuilder bookData = new StringBuilder();

    public DefaultHandler getHandler() {
        return this;
    }

    @Override
    public void startDocument() {
        System.out.println("Start of the document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of the document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        currentSize = 0;
        bookData.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "book":
                processBook(bookData.toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        bookData.append(chars, start, length);
    }

    private void processBook(String book) {
        // Here you can do the security sensitive operation related to A03_Injection
        // For instance, executing SQL queries or manipulating strings in a way that
        // the injection could be vulnerable, e.g., executing SQL queries with user input
        // This is just a placeholder and the real implementation should be done in
        // a secure way according to your requirements.

        System.out.println("Book: " + book);
    }
}