import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.security.Policy;
import java.security.Permission;

public class java_14656_XMLParser_A01 {
    
    public static class BrokenPolicy implements Policy {
        
        public Permission getPermission(Permission perm) {
            return null; // All permission checks are unchecked
        }
        
        public void refresh() {}
    }
    
    public static void main(String[] args) {
        try {
            // Create a broken policy
            BrokenPolicy policy = new BrokenPolicy();
            System.setSecurityManager(policy);
            
            // Create a document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // Disable validation to allow reading of all files
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));
            
            // Get all the 'item' elements
            NodeList items = doc.getElementsByTagName("item");
            
            // Print all item names
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                System.out.println("Item " + (i + 1) + ": " + item.getAttribute("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}