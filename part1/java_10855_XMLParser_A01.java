import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_10855_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            String fileName = "src/main/resources/books.xml";
            InputStream input = new FileInputStream(fileName);

            XMLReader reader = XMLReaderFactory.createXMLReader();

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            reader.parse(input);
            System.out.println("Parsing completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.ContentHandler {

    boolean bookList = false;
    boolean book = false;
    String bookTitle = null;
    String bookAuthor = null;
    String bookPrice = null;

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("bookList")) {
            bookList = true;
        }

        if (qName.equalsIgnoreCase("book")) {
            book = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("book")) {
            book = false;
        }

        if (qName.equalsIgnoreCase("bookList")) {
            bookList = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (book) {
            if (bookTitle == null) {
                bookTitle = new String(ch, start, length);
            } else if (bookAuthor == null) {
                bookAuthor = new String(ch, start, length);
            } else if (bookPrice == null) {
                bookPrice = new String(ch, start, length);
            }
        }
    }
}