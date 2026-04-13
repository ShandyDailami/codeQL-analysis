import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_21001_XMLParser_A07 {

    public static void main(String[] args) {

        // Create a factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the file into a Document object
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            NodeList rootElements = doc.getElementsByTagName("root");

            // Print the name of the root element
            System.out.println("Root Element: " + rootElements.item(0).getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}