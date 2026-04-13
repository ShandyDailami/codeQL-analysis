import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_06649_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Get the DocumentBuilder for a specific document type
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML document
            Document doc = builder.parse(new File("sample.xml"));
            
            // Get the root element
            Element root = doc.getDocumentElement();
            
            // Get all child elements of the root
            NodeList children = root.getChildNodes();
            
            // Iterate over the child nodes
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                
                // Print out the node name and value
                if (node instanceof Element) {
                    Element element = (Element) node;
                    System.out.println("Node Name: " + element.getNodeName());
                    System.out.println("Node Value: " + element.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}