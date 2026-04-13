import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_35645_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bAccessControl = false;
    boolean bRoot = false;
    StringBuilder buffer = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        if (qName.equalsIgnoreCase("access")) {
            bAccessControl = true;
        } else if (qName.equalsIgnoreCase("root")) {
            bRoot = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAccessControl) {
            String accessControl = new String(ch, start, length);
            System.out.println("Access Control: " + accessControl);
            bAccessControl = false;
        } else if (bRoot) {
            String root = new String(ch, start, length);
            System.out.println("Root: " + root);
            bRoot = false;
        }
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("access")) {
            String accessControl = buffer.toString();
            System.out.println("Access Control: " + accessControl);
        } else if (qName.equalsIgnoreCase("root")) {
            String root = buffer.toString();
            System.out.println("Root: " + root);
        }
    }
}