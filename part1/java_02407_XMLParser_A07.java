import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.security.KeyStoreException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import sun.security.x509.X509Subject;

public class java_02407_XMLParser_A07 {

    public static void main(String[] args) {
        // Create the DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Extract the required security sensitive operations
            extractSecureOperations(doc);

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractSecureOperations(Document doc) {
        // Extract and print all the elements with 'secure' in their name
        NodeList nodes = doc.getElementsByTagName("secure");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element node = (Element) nodes.item(i);
            System.out.println("Secure operation: " + node.getAttribute("name"));
        }

        // Extract and print all the attributes with 'authfailure' in their value
        nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element node = (Element) nodes.item(i);
            if (node.getAttribute("authfailure") != null) {
                System.out.println("AuthFailure attribute found in: " + node.getTagName());
            }
        }
    }
}