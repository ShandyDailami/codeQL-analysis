import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13043_XMLParser_A01 extends DefaultHandler {

    boolean isName = false;
    boolean isAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            isName = true;
            isAge = true;
        }
        if (qName.equals("name")) {
            isName = true;
        }
        if (qName.equals("age")) {
            isAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            isName = false;
            isAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        }
        if (isAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        File xmlFile = new File("people.xml");

        try {
            parser.parse(xmlFile, new MySAXHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}