import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_01566_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("books.xml"), new SAXSettings());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bookTitle = false;
        private boolean bookPrice = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("book")) {
                bookTitle = true;
                bookPrice = true;
            } else if (bookTitle) {
                bookTitle = false;
                System.out.println("Book Title: " + qName);
            } else if (bookPrice) {
                bookPrice = false;
                System.out.println("Book Price: " + qName);
            }
        }
    }
}