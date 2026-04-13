import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_12586_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Setup the DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Process the document
            // Here, we just print out the parsed data
            System.out.println("XML Parsed Successfully");

        } catch (IOException e) {
            System.out.println("Failed to parse the XML file. Reason: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Failed to parse the XML file. Reason: " + e.getMessage());
        }
    }
}