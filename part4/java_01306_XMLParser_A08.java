import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01306_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.parse(XmlParser.class.getResourceAsStream("/test.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bBook = false;
        boolean bAuthor = false;
        String curBook = null;
        String curAuthor = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("BOOK")) {
                bBook = true;
                curBook = "";
            } else if (qName.equalsIgnoreCase("AUTHOR")) {
                bAuthor = true;
                curAuthor = "";
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bBook && qName.equalsIgnoreCase("BOOK")) {
                System.out.println("Book: " + curBook);
                bBook = false;
            } else if (bAuthor && qName.equalsIgnoreCase("AUTHOR")) {
                System.out.println("Author: " + curAuthor);
                bAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bBook) {
                curBook = new String(ch, start, length);
            } else if (bAuthor) {
                curAuthor = new String(ch, start, length);
            }
        }
    }
}