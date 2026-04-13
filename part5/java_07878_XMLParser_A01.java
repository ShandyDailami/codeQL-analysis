import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_07878_XMLParser_A01 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Get a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document doc = builder.parse(new File("example.xml"));

            // Here, you can add your security-sensitive operations related to A01_BrokenAccessControl
            // For example, you can print the document's name and namespace
            System.out.println("Document name: " + doc.getDocumentElement().getTagName());
            System.out.println("Document namespace: " + doc.getDocumentElement().getNamespaceURI());

            // To print all elements and attributes
            doc.getElementsByTagName("*").forEach(element -> {
                System.out.println("Element name: " + element.getTagName());
                element.getAttributes().forEach(attribute -> {
                    System.out.println("Attribute name: " + attribute.getNodeName());
                    System.out.println("Attribute value: " + attribute.getNodeValue());
                });
            });
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}