import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21099_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);

            // Set the property for validating mode
            document.getDocumentElement().normalize();

            // Check for correct indentation and tags
            System.out.println(isDocumentWellFormed(document));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to check if a document is well-formed
    private static String isDocumentWellFormed(Document document) {
        try {
            document.getDocumentElement().normalize();
            return "The document is well-formed.";
        } catch (Exception e) {
            return "The document is not well-formed.";
        }
    }
}