import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26962_XMLParser_A01 {
    public static void main(String[] args) {
        String url = "http://www.w3schools.com/xml/books.xml";  // replace with your XML file
        parse(url);
    }

    public static void parse(String url) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class SAXHandler extends DefaultHandler {
        private boolean isAuthor;
        private boolean isGenre;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("author")) {
                isAuthor = true;
            } else if (qName.equals("genre")) {
                isGenre = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("author")) {
                isAuthor = false;
            } else if (qName.equals("genre")) {
                isGenre = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthor) {
                // handle access control related operations here
                System.out.println("Author: " + new String(ch, start, length));
            } else if (isGenre) {
                // handle access control related operations here
                System.out.println("Genre: " + new String(ch, start, length));
            }
        }
    }
}