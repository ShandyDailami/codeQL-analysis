import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_17047_XMLParser_A01 {
    public static void main(String[] args) {
        // Create a new file object for the input XML file
        File inputFile = new File("input.xml");

        // Create a new XMLReader object
        XMLReader reader = null;

        // Use a factory to create a new instance of the SAX parser
        try {
            reader = XMLReaderFactory.createXMLReader();

            // Add an event handler for the startElement event
            reader.setContentHandler(new MyContentHandler());

            // Parse the XML file
            reader.parse(inputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define the MyContentHandler class to handle XML content
    private static class MyContentHandler implements org.xml.sax.ContentHandler {
        private boolean accessControlViolationFound = false;

        // Implement the startElement method
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            // Check for access control violations
            if ("access".equals(localName)) {
                accessControlViolationFound = true;
            }
        }

        // Implement the endElement method
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // If access control violations were found, print an error message
            if (accessControlViolationFound) {
                System.out.println("Access control violation detected in XML file!");
            }
        }

        // Implement the characters method
        public void characters(char[] ch, int start, int length) throws SAXException {
            // If access control violations were found, print a warning message
            if (accessControlViolationFound) {
                System.out.println("Warning: Access control violations detected in XML file!");
            }
        }
    }
}