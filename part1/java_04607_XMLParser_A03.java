import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_04607_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XMLParserHandler handler = new XMLParserHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLParserHandler implements org.xml.sax.ContentHandler {
    boolean isInElement = false;
    String currentElement = null;

    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String uri, String localName, String qName) {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        isInElement = false;
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isInElement && currentElement.equals("security-sensitive-operation")) {
            System.out.println("Running security sensitive operation...");
            // Your code here to handle the operation.
            // This is a placeholder, remove the comment when you're done.
            // Example: System.out.println("Security sensitive operation completed.");
        }
    }
}