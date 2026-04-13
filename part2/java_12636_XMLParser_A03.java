import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_12636_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for the parsing
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Use the builder to parse the XML file
            Document doc = builder.parse(new File("input.xml"));
            
            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("node");
            
            // Iterate over each node and print its name
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                System.out.println("Node name: " + node.getElementsByTagName("name").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}