import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_32689_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Retrieve the root element
            doc.getDocumentElement().normalize();

            // Print all the nodes in the document
            printNodes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print all nodes in the document
    private static void printNodes(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            // If the node is an element
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Element : " + nNode.getNodeName());

                // If the element is a text node
                if (nNode.getChildNodes().item(0).getNodeType() == Node.TEXT_NODE) {
                    System.out.println("Text Node: " + nNode.getChildNodes().item(0).getNodeValue());
                }

                // If the element is a element node
                if (nNode.getChildNodes().item(0).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Element Node: " + nNode.getChildNodes().item(0).getNodeName());
                }
            }
        }
    }
}