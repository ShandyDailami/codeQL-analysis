import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_02924_XMLParser_A08 {
    public static void main(String[] args) {
        // Step 1: Setup
        File xmlFile = new File("example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Step 2: Create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Parse the XML
        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Step 4: Extract and print elements
        NodeList nodeList = document.getElementsByTagName("element");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element " + (i + 1) + ": " + nodeList.item(i).getTextContent());
        }

        // Step 5: Security-sensitive operations
        // In this case, we're just going to print the element names.
        // Depending on the security-sensitive operation, we might need to add or remove elements.
        // For example, we can add a new element:
        document.createElement("new_element");
        document.appendChild(document.getElementsByTagName("element").item(0), document.createElement("new_element"));
    }
}