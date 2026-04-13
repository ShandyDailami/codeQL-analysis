import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.XMLConstants;

public class java_06284_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Get all the 'item' nodes
            NodeList itemNodes = doc.getElementsByTagName("item");

            // Iterate over the 'item' nodes
            for (int i = 0; i < itemNodes.getLength(); i++) {
                Node itemNode = itemNodes.item(i);

                // If the 'item' node is an element
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;

                    // Print the 'name' attribute of the 'item' element
                    System.out.println("Name: " + itemElement.getAttribute("name"));
                }
            }

            // Close the Document
            doc.detach();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}