import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_11738_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Get the XML Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("input.xml");

            // Print all the elements in the document
            printElements(doc);

            // Perform security-sensitive operations related to injection
            String injectedData = "Injected Data";
            insertInjection(doc, injectedData);

            // Print the modified document
            doc.getDocumentElement().normalize();
            System.out.println("\nModified Document:");
            printElements(doc);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeName());
        }
    }

    private static void insertInjection(Document doc, String injectedData) {
        // Inject the injectedData into the document
        // This operation is security-sensitive and should not be done on a live document
        // For the sake of simplicity, we'll print a message and ignore the injectedData
        System.out.println("Injection operation: " + injectedData);
    }
}