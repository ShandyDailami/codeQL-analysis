import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09297_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/myfile.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder content;
    private String currentElement;

    public java_09297_XMLParser_A08() {
        content = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        content.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equalsIgnoreCase("person")) {
            System.out.println("Name: " + content.toString());
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content.append(new String(ch, start, length));
    }
}