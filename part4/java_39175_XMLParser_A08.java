import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_39175_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parse Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    public void startDocument() {
        System.out.println("Start Document");
    }

    public void endDocument() {
        System.out.println("End Document");
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}