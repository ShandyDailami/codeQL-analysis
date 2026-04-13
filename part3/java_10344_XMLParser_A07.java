import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_10344_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Create a new Document
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element
            NodeList nl = doc.getElementsByTagName("");

            // Traverse through the XML nodes
            for (int temp = 0; temp < nl.getLength(); temp++) {
                Node n = nl.item(temp);
                // Print all the elements
                if (n instanceof Element) {
                    System.out.println("Element: " + n.getNodeName());
                }
            }

            // Close the document
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}