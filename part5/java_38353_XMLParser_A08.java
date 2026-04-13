import java.util.Iterator;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38353_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("input.xml"), myHandler);
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAuthor;
        private boolean bGenre;

        @Override
        public void startDocument() throws SAXException {
            bName = bAuthor = bGenre = true;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                System.out.println("Book ID: " + attributes.getValue("id"));
                System.out.println("Name: " + attributes.getValue("name"));
            } else if (qName.equals("author")) {
                bAuthor = false;
            } else if (qName.equals("genre")) {
                bGenre = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                bName = bAuthor = bGenre = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("Name: ");
                bName = false;
            } else if (bAuthor) {
                System.out.print("Author: ");
                bAuthor = false;
            } else if (bGenre) {
                System.out.print("Genre: ");
                bGenre = false;
            }
            System.out.print(new String(ch, start, length));
        }
    }
}