import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_11398_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            // Get all elements of type 'node'
            NodeList nodeList = doc.getElementsByTagName("node");

            // Handle each node
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
                
                // Security-sensitive operation: Access control
                if ("admin".equals(node.getTextContent())) {
                    System.out.println("Access Denied!");
                    return;
                }
            }

            System.out.println("Access Granted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}