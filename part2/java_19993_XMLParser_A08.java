import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_19993_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new CustomContentHandler());
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class CustomContentHandler implements org.xml.sax.ContentHandler {
    private boolean integrityFailure = false;

    @Override
    public void startDocument() {
        // Empty implementation
    }

    @Override
    public void endDocument() {
        // Empty implementation
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        // Empty implementation
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Empty implementation
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Check for integrity failure
        if (new String(ch, start, length).trim().length() == 0) {
            integrityFailure = true;
        }
    }

    public boolean isIntegrityFailure() {
        return integrityFailure;
    }
}