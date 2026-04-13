import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_23609_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get all the nodes
            NodeList nodes = doc.getElementsByTagName("*");

            // Loop through all the nodes and print them
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Tag: " + node.getNodeName());
                System.out.println("Value: " + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}