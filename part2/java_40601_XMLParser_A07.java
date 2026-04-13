import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamConstants;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_40601_XMLParser_A07 extends DefaultHandler {
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("person")) {
            System.out.println("Name: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            SAXReader reader = new SAXReader();
            File file = new File("src/main/resources/people.xml");
            reader.setContentHandler(parser);
            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}