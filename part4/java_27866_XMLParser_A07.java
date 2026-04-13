import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27866_XMLParser_A07 {

    public static void main(String[] args) {
        String url = "http://example.com/books.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(url, new DefaultHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        boolean bookTitle = false;
        boolean bookPrice = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bookTitle = true;
                bookPrice = true;
            }
            if (qName.equalsIgnoreCase("title")) {
                bookTitle = true;
            }
            if (qName.equalsIgnoreCase("price")) {
                bookPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bookTitle = false;
                bookPrice = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bookTitle) {
                System.out.println("Book Title: " + new String(ch, start, length));
            }
            if (bookPrice) {
                System.out.println("Book Price: " + new String(ch, start, length));
            }
        }
    }
}