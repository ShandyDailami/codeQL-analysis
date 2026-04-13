import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32320_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("example.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAuthor;
        private boolean bGenre;

        @Override
        public void startDocument() throws SAXException {
            bName = bAuthor = bGenre = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                System.out.println("Book Title : " + attributes.getValue("title"));
                System.out.println("Book Author : " + attributes.getValue("author"));
                System.out.println("Book Genre  : " + attributes.getValue("genre"));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                System.out.println("------------------------");
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            } else if (qName.equalsIgnoreCase("genre")) {
                bGenre = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("Book Title : ");
                bName = false;
            } else if (bAuthor) {
                System.out.print("Book Author : ");
                bAuthor = false;
            } else if (bGenre) {
                System.out.print("Book Genre  : ");
                bGenre = false;
            }
            System.out.print(new String(ch, start, length));
        }
    }
}