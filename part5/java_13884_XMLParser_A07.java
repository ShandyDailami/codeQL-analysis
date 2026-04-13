import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13884_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bUser = false;
    boolean bName = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("user")) bUser = true;
        if (qName.equalsIgnoreCase("name")) bName = true;
        if (qName.equalsIgnoreCase("age")) bAge = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) bUser = false;
        if (qName.equalsIgnoreCase("name")) bName = false;
        if (qName.equalsIgnoreCase("age")) bAge = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUser) {
            // Extract user details and print them out
            System.out.println("User: " + new String(ch, start, length));
        }
        if (bName) {
            // Extract user details and print them out
            System.out.println("Name: " + new String(ch, start, length));
        }
        if (bAge) {
            // Extract user details and print them out
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}