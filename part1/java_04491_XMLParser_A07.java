import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04491_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("src/input.xml"); // replace with your file
            parser.parse(inputFile, new SAXHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isName = false;
    private boolean isAuthor = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("author")) {
            isAuthor = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("name")) {
            isName = false;
        } else if (qName.equals("author")) {
            isAuthor = false;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isAuthor) {
            System.out.println("Author: " + new String(ch, start, length));
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean isBook = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("book")) {
            isBook = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("book")) {
            isBook = false;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isBook) {
            System.out.println("Book: " + new String(ch, start, length));
        }
    }
}