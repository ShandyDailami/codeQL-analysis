import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_34244_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for the parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file and create a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get all the nodes
            NodeList nodes = doc.getElementsByTagName("node");

            // Iterate over all the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Node " + (i+1) + ": " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}