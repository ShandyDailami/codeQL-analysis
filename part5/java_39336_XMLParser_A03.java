import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_39336_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for handling the document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Use the factory to get a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the document
            Document document = builder.parse(new File("example.xml"));

            // Normalize the document
            document.getDocumentElement().normalize();

            // Get the list of elements
            NodeList nodeList = document.getElementsByTagName("element");

            // Process the list
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Element " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}