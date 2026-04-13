import java.io.File;
import java.io.IOException;
import java.security.ProtectionDomain;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_09534_XMLParser_A03 {

    public static void main(String[] args) {

        // Create an instance of DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a new DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("item");

            // Loop through each node
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Print the value of the node
                System.out.println("Value: " + node.getTextContent());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}