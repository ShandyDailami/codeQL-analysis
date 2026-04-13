import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09014_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.xml"; // replace with your file path
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            Handler handler = new Handler();
            parser.parse(new File(filePath), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends DefaultHandler {
        boolean bookFound = false;
        boolean titleFound = false;
        boolean authorFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bookFound = true;
            } else if (bookFound && qName.equalsIgnoreCase("title")) {
                titleFound = true;
            } else if (bookFound && qName.equalsIgnoreCase("author")) {
                authorFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bookFound = false;
            } else if (bookFound && qName.equalsIgnoreCase("title")) {
                titleFound = false;
            } else if (bookFound && qName.equalsIgnoreCase("author")) {
                authorFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bookFound && titleFound && !authorFound) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bookFound && authorFound && !titleFound) {
                System.out.println("Author: " + new String(ch, start, length));
            }
        }
    }
}