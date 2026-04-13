import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_35341_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<books><book id='1'><title>Book1</title><author>Author1</author></book><book id='2'><title>Book2</title><author>Author2</author></book></books>";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse(new StringReader(xml), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bTitle = false;
        private boolean bAuthor = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                System.out.println("Title: " + new String(ch, start, length));
                bTitle = false;
            } else if (bAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
                bAuthor = false;
            }
        }
    }
}