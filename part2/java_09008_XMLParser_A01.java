import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_09008_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml")); // replace with your file

            // Step 2: Extract and print the element names and values
            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());
                    System.out.println("Value: " + element.getFirstChild().getNodeValue());
                }
            }

            // Step 3: Handle security-sensitive operations
            // This is a simplified example. In a real application, you would need to handle
            // more complex situations, like access controls, permissions, etc.
            // For security-sensitive operations, you should use secure libraries or frameworks.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}