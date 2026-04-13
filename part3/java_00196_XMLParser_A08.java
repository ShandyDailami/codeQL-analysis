import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_00196_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Get all nodes
            NodeList nList = doc.getElementsByTagName("node");

            // Iterate over each node
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);

                // If the node is a element node, print out the node name and value
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Node name: " + element.getNodeName());
                    System.out.println("Node value: " + element.getFirstChild().getNodeValue());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}