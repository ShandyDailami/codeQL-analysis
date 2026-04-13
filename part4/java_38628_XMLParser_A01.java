import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.net.URL;
import java.io.IOException;

public class java_38628_XMLParser_A01 {

    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and a Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        // Step 2: Use DocumentBuilderFactory to get a Document
        try {
            doc = builder.parse(new URL("http://example.com/config.xml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        // Step 3: Use Document to handle the parsed XML data
        }

        // Step 4: Find the root element and print the element name
        Element root = doc.getDocumentElement();
        System.out.println("Root element name: " + root.getNodeName());

        // Step 5: Find and print all elements under the root element
        NodeList list = doc.getElementsByTagName("*");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);
            System.out.println("Element " + i + ": " + e.getNodeName());
        }

        // Step 6: Accessing security sensitive operations with Document API
        // This is a simplistic example, in a real-world application, you would need to add more security measures
        // like checking permissions on file operations or database access
        // You could also use a library or framework to perform these operations
        // This is not included in this example
    }
}