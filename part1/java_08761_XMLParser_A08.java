import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_08761_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element of the Document
            doc.getDocumentElement().normalize();

            // Get all the child nodes of the root element
            NodeList nodes = doc.getElementsByTagName("*");

            // Print the data to the console
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}