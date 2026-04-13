import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40843_XMLParser_A08 extends DefaultHandler {

    private String lastElement;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement.equals("element")) {
            String value = new String(ch, start, length);
            System.out.println("Value: " + value);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);
            MyHandler handler = new MyHandler();

            saxParser.parse(new File("src/main/resources/test.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}