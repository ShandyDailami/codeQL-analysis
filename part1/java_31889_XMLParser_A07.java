import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_31889_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));
            
            // Get the root element
            Element root = doc.getDocumentElement();
            
            // Get all the child elements
            NodeList children = root.getChildNodes();
            
            // Iterate through each child
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                
                // Check if the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    // Print the name and value of the element
                    System.out.println("Name: " + element.getNodeName());
                    System.out.println("Value: " + element.getFirstChild().getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}