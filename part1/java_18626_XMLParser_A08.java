import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_18626_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    boolean bNodeFound = false;
    String thisElement = "";
    String thisText = "";

    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) {
        bNodeFound = true;
        thisElement = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        bNodeFound = false;
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bNodeFound) {
            thisText = new String(ch, start, length);
            System.out.println("Element: " + thisElement + ", Text: " + thisText);
        }
    }
}