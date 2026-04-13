import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_12423_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(xmlFile.toURI().toURL());
            MyHandler handler = new MyHandler();
            parser.parse(xmlFile, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean inElement = false;
    private String currentElement = "";
    private String currentValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        inElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (inElement) {
            currentValue = new String(chars, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        inElement = false;
        System.out.println("Element: " + currentElement + ", Value: " + currentValue);
        currentElement = "";
        currentValue = "";
    }
}