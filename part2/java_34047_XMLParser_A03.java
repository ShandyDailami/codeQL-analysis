import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_34047_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();

            saxParser.parse(new File("input.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bTitle = false;
    private boolean bLink = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
        }

        if (qName.equalsIgnoreCase("link")) {
            bLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            bTitle = false;
        }

        if (qName.equalsIgnoreCase("link")) {
            bLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTitle) {
            System.out.println("Title: " + new String(ch, start, length));
        }

        if (bLink) {
            System.out.println("Link: " + new String(ch, start, length));
        }
    }
}