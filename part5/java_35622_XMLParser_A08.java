import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_35622_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bookTitle = false;
        private boolean bookPrice = false;

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
                bookTitle = false;
            }

            if (bookPrice) {
                System.out.println("Book Price: " + new String(ch, start, length));
                bookPrice = false;
            }
        }
    }
}