import org.xml.sax.SAXException;
import org.xml.sax.SAXReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_32976_XMLParser_A01 extends DefaultHandler {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            reader.setContentHandler(new XMLParser());
            reader.parse(new File("sample.xml")); // replace with your xml file
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Dictionary attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}