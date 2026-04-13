import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_38136_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuffer buffer = new StringBuffer();
    private boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (authFailure) {
            // Security sensitive operation related to A07_AuthFailure
            // For example, logging the message
            System.out.println("AuthFailure detected: " + buffer.toString());
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Ignore prefix mapping
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Ignore prefix mapping
    }
}