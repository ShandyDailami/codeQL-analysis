import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_33664_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());

            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    public void startDocument() {
        System.out.println("Start of the document");
    }

    public void endDocument() {
        System.out.println("End of the document");
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start of " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}