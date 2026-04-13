import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_22874_XMLParser_A03 {

    public static void main(String[] args) {
        // Step 1: Setup DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation
        factory.setNamespaceAware(true); // Enable namespace awareness

        // Step 2: Create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Parse the XML file
        Document doc = null;
        try {
            doc = builder.parse(new File("yourXmlFile.xml"));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
            return;
        }

        // Step 4: Process the Document
        // This is a very basic example and may not be suitable for all use cases.
        // In a real-world application, you would likely want to process the document in a more sophisticated way.
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
    }
}