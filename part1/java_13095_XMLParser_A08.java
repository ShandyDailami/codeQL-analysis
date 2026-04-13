import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13095_XMLParser_A08 {
    public static void main(String[] args) {
        String url = "http://www.w3schools.com/xml/books.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(url, new SAXSource(new InputSource(url)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DefaultHandler
    static class MyHandler extends DefaultHandler {
        private boolean bookTitle = false;
        private boolean author = false;
        private boolean price = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                System.out.println("Book id: " + attributes.getValue("id"));
            } else if (qName.equalsIgnoreCase("title")) {
                bookTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                author = true;
            } else if (qName.equalsIgnoreCase("price")) {
                price = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bookTitle = false;
                author = false;
                price = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bookTitle) {
                System.out.println("Book Title: " + new String(ch, start, length));
            } else if (author) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (price) {
                System.out.println("Price: " + new String(ch, start, length));
            }
        }
    }
}