import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_41661_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a new document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            // Get the node list of the document
            NodeList nodeList = doc.getElementsByTagName("record");

            // Iterate through the list
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current node
                org.w3c.dom.Element element = (org.w3c.dom.Element) nodeList.item(i);

                // Extract data from the current node
                String id = element.getAttribute("id");
                String name = element.getAttribute("name");

                // Do some security-sensitive operations with the extracted data
                // ...
            }

            // Close the document
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}