import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_12261_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new instance of DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Read the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Get all the nodes from the document
            NodeList nodeList = doc.getElementsByTagName("node");

            // Iterate over the nodes and print the node name and value
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}