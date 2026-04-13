import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class java_00072_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("input.xml"), myHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bBook = false;
        boolean bAuthor = false;
        String currValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = true;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bBook) {
                currValue = new String(ch, start, length);
                bBook = false;
            } else if (bAuthor) {
                // Security-sensitive operation related to A03_Injection
                // e.g., use of '+' to append value to currValue
                currValue += new String(ch, start, length);
                bAuthor = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                System.out.println("Book: " + currValue);
            } else if (qName.equalsIgnoreCase("author")) {
                System.out.println("Author: " + currValue);
            }
        }
    }
}