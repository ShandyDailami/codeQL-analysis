import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10586_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            // Get DocumentBuilder from factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));
            
            // Get root element of the document
            doc.getDocumentElement().normalize();
            
            // Get the value of a node
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            
            // Get all 'item' nodes
            NodeList nList = doc.getElementsByTagName("item");
            
            // Iterate over the nodes
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                
                // Print all child nodes of the item node
                System.out.println("\nItem: " + ((Element)nNode).getTagName());
                System.out.println("Price: " + ((Element)nNode).getAttribute("price"));
                System.out.println("Description: " + ((Element)nNode).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}