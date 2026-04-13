import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_41015_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and set up the parser
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element of the XML document
            doc.getDocumentElement().normalize();

            // Get all elements with a tag name
            NodeList nList = doc.getElementsByTagName("element");

            // Iterate over each node
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // Print the value of the node
                System.out.println("Value of node " + (temp + 1) + " : " + nNode.getNodeValue());

                // Check for authentication failure
                if ("authFailure".equals(nNode.getNodeValue())) {
                    System.out.println("Authentication failure detected!");
                    // Perform security-sensitive operations here
                }
           
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}