import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_11981_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("resources/sample.xml");

        // Create a SAX parser
        XMLReader saxReader;
        try {
            saxReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Error creating SAX parser: " + e.getMessage());
            return;
        }

        // Set the ContentHandler for the SAX parser
        saxReader.setContentHandler(new XMLContentHandler());

        // Parse the XML file
        try {
            saxReader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
            return;
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
            return;
        }
    }
}