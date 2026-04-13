import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12806_XMLParser_A01 extends DefaultHandler {
    private String lastElement;
    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = false;
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        } else {
            bName = bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("src/main/resources/people.xml"), MyHandler.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}