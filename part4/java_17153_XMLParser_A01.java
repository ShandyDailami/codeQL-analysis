import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_17153_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document document = builder.parse(new File("input.xml"));
            
            // Get all the 'item' elements
            NodeList items = document.getElementsByTagName("item");
            
            // Iterate over each 'item'
            for (int i = 0; i < items.getLength(); i++) {
                Node itemNode = items.item(i);
                if (itemNode instanceof Element) {
                    Element itemElement = (Element) itemNode;
                    
                    // Get the 'name' attribute and print it
                    String name = itemElement.getAttribute("name");
                    System.out.println("Name: " + name);
                    
                    // Get the 'description' element and print it
                    Element descriptionElement = (Element) itemElement.getElementsByTagName("description").item(0);
                    String description = descriptionElement.getTextContent();
                    System.out.println("Description: " + description);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}