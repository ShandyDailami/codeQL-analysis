import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_17471_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            parser.parse(XMLParserExample.class.getResourceAsStream("example.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bBook = false;
        boolean bAuthor = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("book")) {
                bBook = true;
            } else if (qName.equals("author")) {
                bAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                bBook = false;
            } else if (qName.equals("author")) {
                bAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (bAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            }
        }
    }
}