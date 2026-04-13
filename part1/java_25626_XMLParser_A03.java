import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_25626_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "books.xml";
        parseFile(filePath);
    }

    private static void parseFile(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bookTitle = false;
    private boolean bookPrice = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("-----------------");
            System.out.println("Starting element: " + qName);
        }

        if (qName.equalsIgnoreCase("title")) {
            bookTitle = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bookPrice = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Ending element: " + qName);
            System.out.println("-----------------");
            bookTitle = false;
            bookPrice = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bookTitle) {
            System.out.println("Book title: ");
            bookTitle = false;
        } else if (bookPrice) {
            System.out.println("Book price: ");
            bookPrice = false;
        }
    }
}