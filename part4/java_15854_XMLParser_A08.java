import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15854_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        try {
            parser.parse(new File("books.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean isBook = false;
        boolean isTitle = false;
        boolean isPrice = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                isBook = true;
            } else if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("price")) {
                isPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                isBook = false;
            } else if (qName.equals("title")) {
                isTitle = false;
            } else if (qName.equals("price")) {
                isPrice = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (isTitle) {
                System.out.print("Title: " + new String(ch, start, length));
                isTitle = false;
            } else if (isPrice) {
                System.out.println("Price: " + new String(ch, start, length));
                isPrice = false;
            }
        }
    }
}