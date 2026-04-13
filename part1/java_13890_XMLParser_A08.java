import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_13890_XMLParser_A08 {

    public static void main(String[] args) {

        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder from the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Read the input file
            Document doc = dBuilder.parse(new File("input.xml"));

            // Retrieve the root element
            NodeList nList = doc.getElementsByTagName("*");

            // Process each node
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // Print the node name and its attributes
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nNode;
                    System.out.println("Element : " + e.getTagName());
                }
            }

            // Close the document
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}