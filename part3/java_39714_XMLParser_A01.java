import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_39714_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Get the DocumentBuilderFactory instance
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Get the DocumentBuilder instance
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("example.xml"));

            // Get the root element
            Element rootElement = doc.getDocumentElement();

            // Get all 'item' elements
            NodeList itemList = rootElement.getElementsByTagName("item");

            // Print all 'item' elements
            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;
                    System.out.println("Item " + (i + 1) + ": ");
                    System.out.println("Item name: " + itemElement.getAttribute("name"));
                    System.out.println("Item price: " + itemElement.getAttribute("price"));
                    System.out.println("--------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}