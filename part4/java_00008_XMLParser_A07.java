import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_00008_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml"); // replace with your xml file
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    boolean inElement = false;
    String currentElement = null;

    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        inElement = true;
        currentElement = qName;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        inElement = false;
        currentElement = null;
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (inElement) {
            System.out.println("Characters: " + new String(chars, start, length));
        }
    }
}