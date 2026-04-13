import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.SAXParser;

import java.io.File;
import java.io.IOException;

public class java_21800_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(new File("example.xml"), saxHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAuthor;
    private String currentValue;

    @Override
    public void startDocument() throws SAXException {
        bName = bAuthor = true;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("book")) {
            return;
        }

        if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("author")) {
            bAuthor = true;
        } else {
            bName = bAuthor = false;
            currentValue = qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            currentValue += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            return;
        }

        if (qName.equals("name")) {
            System.out.println("Name: " + currentValue);
        } else if (qName.equals("author")) {
            System.out.println("Author: " + currentValue);
        }

        bName = bAuthor = false;
        currentValue = null;
    }
}