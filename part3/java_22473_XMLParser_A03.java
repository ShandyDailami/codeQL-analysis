import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_22473_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";  // The file to parse

        // Create a factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidate(true);  // Enable validation

        // Use the factory to create a new DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document doc = null;
        try {
            doc = builder.parse(new File(xmlFile));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        // Process the document here
        // This is a placeholder and will not execute if the XML file is not well-formed
        System.out.println("Parsing completed successfully!");
    }
}