import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_37088_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Read the input xml file
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get all the element nodes
            NodeList nList = doc.getElementsByTagName("*");

            // Iterate through all the nodes
            for (int temp = 0; temp < nList.getLength(); temp++) {
                // Print out the name of each node
                Node n = nList.item(temp);
                System.out.println("Node name: " + n.getNodeName());
            }

            // Close the input file
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }
}