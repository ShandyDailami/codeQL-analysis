import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26151_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File("books.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bBook = false;
        boolean bAuthor = false;
        String thisAuthor = null;
        String thisTitle = null;
        String thisPrice = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = true;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = false;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bBook) {
                thisTitle = new String(ch, start, length);
            } else if (bAuthor) {
                thisAuthor = new String(ch, start, length);
            } else if (bAuthor && bBook) {
                thisPrice = new String(ch, start, length);
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            // no-op
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            // no-op
        }
    }
}