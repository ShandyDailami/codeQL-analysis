import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_24075_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for reading the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Read the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("*");

            // Print out each element and its attribute
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Element: " + node.getNodeName());
                if (node.hasAttributes()) {
                    for (int j = 0; j < node.getAttributes().getLength(); j++) {
                        System.out.println("Attribute: " + node.getAttributes().item(j).getNodeName() + " = " + node.getAttributes().item(j).getTextContent());
                   
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}