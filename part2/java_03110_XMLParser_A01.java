import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03110_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document document = builder.parse("input.xml");

            // Get all the nodes in the document
            NodeList nodes = document.getElementsByTagName("*");
            
            // Iterate over all nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node " + (i+1) + ": " + nodes.item(i).getNodeName());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}