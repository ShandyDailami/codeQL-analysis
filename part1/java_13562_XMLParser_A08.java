import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_13562_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // factory true for strict mode

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("books.xml"), handler); // parse xml file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder currentElement;
    private boolean isTitle = false;
    private boolean isAuthor = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = new StringBuilder(qName);

        if (qName.equals("book")) {
            System.out.println("-------------------------");
        } else if (qName.equals("title")) {
            isTitle = true;
        } else if (qName.equals("author")) {
            isAuthor = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            System.out.println("-------------------------");
        } else if (qName.equals("title")) {
            isTitle = false;
        } else if (qName.equals("author")) {
            isAuthor = false;
        }

        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null && isTitle) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (currentElement != null && isAuthor) {
            System.out.println("Author: " + new String(ch, start, length));
        }
    }
}