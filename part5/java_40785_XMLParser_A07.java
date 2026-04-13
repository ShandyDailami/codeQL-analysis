import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40785_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "src/test.xml"; // your xml file path here
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bStart = false;
        boolean bAuthor = false;
        boolean bBook = false;
        boolean bTitle = false;
        String author = null;
        String book = null;
        String title = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = true;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = true;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = false;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bBook) {
                book = new String(ch, start, length);
            } else if (bAuthor) {
                author = new String(ch, start, length);
            } else if (bTitle) {
                title = new String(ch, start, length);
            }
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}