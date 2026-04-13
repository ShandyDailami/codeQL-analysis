import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

public class java_17417_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParser saxParser = new SAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MyHandler myHandler = new MyHandler();

            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(new FileReader("data.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
            System.out.println("Person: " + "Name = " + attributes.getValue("name") + ", Age = " + attributes.getValue("age"));
        } else if (bName) {
            System.out.println("Name: " + localName);
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + localName);
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}