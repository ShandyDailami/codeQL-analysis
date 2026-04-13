import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_40306_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Get all 'item' elements
            NodeList items = doc.getElementsByTagName("item");

            // Iterate over all 'item' elements
            for (int i = 0; i < items.getLength(); i++) {
                Node itemNode = items.item(i);
                if (itemNode instanceof Element) {
                    Element itemElem = (Element) itemNode;

                    // Get the 'name' and 'quantity' values of each item
                    String name = itemElem.getAttribute("name");
                    String quantity = itemElem.getAttribute("quantity");

                    System.out.println("Item " + i + ": Name = " + name + ", Quantity = " + quantity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}