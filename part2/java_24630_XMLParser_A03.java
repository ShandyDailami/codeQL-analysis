import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_24630_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("sample");

            // Loop through each node and print the node name
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Sample: " + node.getNodeName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}