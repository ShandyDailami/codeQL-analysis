import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_41567_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Use builder to parse the file
            Document doc = builder.parse(new File("input.xml"));
            
            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("*");
            
            // Loop through each node
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Get the name of the element and its value
                    String elementName = element.getNodeName();
                    String elementValue = element.getTextContent();
                    // Print out the element name and value
                    System.out.println("Element name: " + elementName);
                    System.out.println("Element value: " + elementValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}