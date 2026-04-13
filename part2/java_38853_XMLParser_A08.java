import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_38853_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/example.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = new StringBuilder();
        currentElement.append("Start element: ").append(qName);
        System.out.println(currentElement.toString());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement.append(" End element: ").append(qName);
        System.out.println(currentElement.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElement.append(new String(ch, start, length));
    }
}