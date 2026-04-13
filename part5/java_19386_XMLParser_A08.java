import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19386_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(xmlFile), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean isPerson = false;
    boolean isName = false;
    boolean isAge = false;

    String name;
    String age;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = true;
            isName = false;
            isAge = false;
        } else if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            isAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isPerson) {
            isPerson = false;
            return;
        }

        if (isName) {
            name = new String(ch, start, length);
        } else if (isAge) {
            age = new String(ch, start, length);
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
}