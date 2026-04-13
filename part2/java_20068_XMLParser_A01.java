import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_20068_XMLParser_A01 {
    public List<String> parse(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFilePath));

            // Validate document
            System.out.println("Document parsing succeeded");

            // Extract and print all namespaces
            doc.getXmlResolver().getNamespaceDeclarations().stream().forEach(ns -> System.out.println("Namespace: " + ns.getPrefix() + " = " + ns.getNamespaceURI()));

            // Extract and print all 'A' elements
            doc.getElementsByTagName("A").stream().forEach(el -> System.out.println("Found 'A' element: " + el.getTextContent()));

            return doc.getElementsByTagName("A").stream().map(el -> el.getTextContent()).toList();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
            return List.of();
        }
    }
}