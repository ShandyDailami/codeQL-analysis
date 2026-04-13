import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_37953_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader("<root><item>data1</item><item>data2</item></root>")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean item = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            item = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            item = false;
        } else if (item) {
            System.out.println("Item: " + qName);
        }
    }
}