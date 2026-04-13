import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39974_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler handler = new MyHandler();
        try {
            saxParser.parse(new File("src/main/resources/books.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean isTitle = false;
        boolean isAuthor = false;
        boolean isYear = false;

        String title;
        String author;
        String year;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("author")) {
                isAuthor = true;
            } else if (qName.equals("year")) {
                isYear = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                title = new String(ch, start, length);
                isTitle = false;
            } else if (isAuthor) {
                author = new String(ch, start, length);
                isAuthor = false;
            } else if (isYear) {
                year = new String(ch, start, length);
                isYear = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Year: " + year);
            }
        }
    }
}