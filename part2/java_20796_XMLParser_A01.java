import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicStAXContentHandler;

public class java_20796_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Initialize the SAX Parser
        BasicStAXContentHandler contentHandler = new BasicStAXContentHandler();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(contentHandler);

        // Step 2: Define a SAX event handler
        SaxEventHandler eventHandler = new SaxEventHandler();
        reader.setContentHandler(eventHandler);

        // Step 3: Process the XML
        try {
            reader.parse("src/main/resources/sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Step 4: Print the parsed data
        System.out.println("Parsed data: " + contentHandler.getResult());
    }
}