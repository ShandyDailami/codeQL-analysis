import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_08939_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new SAXHandler());
        try {
            parser.parse(new File("books.xml"), new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean author;
    private boolean title;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("author")) {
            author = true;
        } else if (qName.equals("title")) {
            title = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            // Security-sensitive operation related to A07_AuthFailure
        } else if (qName.equals("author")) {
            author = false;
        } else if (qName.equals("title")) {
            title = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (author) {
            // Security-sensitive operation related to A07_AuthFailure
        } else if (title) {
            // Security-sensitive operation related to A07_AuthFailure
        }
    }
}