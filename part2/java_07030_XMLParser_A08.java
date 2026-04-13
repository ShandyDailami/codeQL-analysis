import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.event.SaxNotSupportedException;

import java.io.File;
import java.io.IOException;

public class java_07030_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a new file instance
        File file = new File("sample.xml");

        // Create a SAX reader
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SaxNotSupportedException e) {
            System.err.println("SAX not supported!");
            return;
        }

        // Create a new event handler
        MyHandler handler = new MyHandler();

        // Set the event handler for start elements
        reader.setContentHandler(handler);

        // Parse the XML file
        try {
            reader.parse(file);
        } catch (SAXException e) {
            System.err.println("Error parsing XML file: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("Error reading XML file: " + e.getMessage());
            return;
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    private boolean integrityFailure = false;

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("node")) {
            // Check if the node contains a security-sensitive attribute
            String sensitiveAttribute = attributes.getValue("sensitive");
            if (sensitiveAttribute != null && sensitiveAttribute.equalsIgnoreCase("true")) {
                // If the attribute is found to be 'true', raise the integrityFailure flag
                integrityFailure = true;
            }
        }
    }

    public void endDocument() {
        if (integrityFailure) {
            System.out.println("Integrity failure detected.");
        } else {
            System.out.println("No integrity failures detected.");
        }
    }
}