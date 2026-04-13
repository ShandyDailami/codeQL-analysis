import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_31549_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        // Load the XML file
        File file = new File("sample.xml");
        InputStream stream = new FileInputStream(file);

        // Create a SAX parser
        SAXParser parser = SAXParserFactory.newInstance().createSAXParser();

        // Create a XML reader
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Set the content handler
        parser.setContentHandler(new MyContentHandler(reader));

        // Parse the XML
        parser.parse(new InputSource(stream));
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    private org.xml.sax.ContentHandler handler;

    public java_31549_XMLParser_A01(org.xml.sax.ContentHandler handler) {
        this.handler = handler;
    }

    public void startDocument() {
        // Not used in this example
    }

    public void endDocument() {
        // Not used in this example
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        // This is where we handle the start of an element
        System.out.println("Start element: " + localName);
    }

    public void endElement(String uri, String localName, String qName) {
        // This is where we handle the end of an element
        System.out.println("End element: " + localName);
    }

    public void characters(char[] ch, int start, int length) {
        // This is where we handle characters data
        String data = new String(ch, start, length);
        System.out.println("Character data: " + data);
    }

    public void ignorableWhitespace(char[] ch, int start, int length) {
        // Not used in this example
    }

    public void processingInstruction(String target, String data) {
        // Not used in this example
    }

    public void setElementQuirksMode(boolean quirks) {
        // Not used in this example
    }

    public void startPrefixMapping(String prefix, String uri) {
        // Not used in this example
    }

    public void endPrefixMapping(String prefix) {
        // Not used in this example
    }
}