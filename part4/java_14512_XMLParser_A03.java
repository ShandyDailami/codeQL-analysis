import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14512_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("books.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean author = false;
        private boolean title = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                author = true;
            } else if (qName.equalsIgnoreCase("title")) {
                title = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                author = false;
            } else if (qName.equalsIgnoreCase("title")) {
                title = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (author) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (title) {
                System.out.println("Title: " + new String(ch, start, length));
            }
        }
    }
}