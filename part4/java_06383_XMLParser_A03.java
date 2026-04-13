import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_06383_XMLParser_A03 extends DefaultHandler {

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName) {
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();
        if (!value.isEmpty()) {
            System.out.println("Value of element: " + value);
        }
    }

    public void fatalError(String error) {
        System.out.println("Fatal Error: " + error);
    }

    public static void main(String[] args) throws ParserException, SAXException, IOException {
        String filename = "/path/to/your/xml/file.xml";
        File file = new File(filename);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MySAXHandler handler = new MySAXHandler();
        parser.parse(file, handler);
    }
}