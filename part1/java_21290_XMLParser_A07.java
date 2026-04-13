import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_21290_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), new SAXSource(new MyHandler()));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length);
        System.out.println("Text: " + s);
    }
}