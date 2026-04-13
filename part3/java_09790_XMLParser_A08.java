import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_09790_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/example.xml";
        parseXMLFile(filePath);
    }

    public static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
       
        }

        // Get the root element
        Element rootElement = document.getDocumentElement();

        // Traverse through child nodes of the root element
        printNode(rootElement);
    }

    private static void printNode(Element node) {
        // Print the node name and value
        System.out.println("Node name: " + node.getNodeName());
        System.out.println("Node value: " + node.getTextContent());

        // Get the list of child nodes
        NodeList childNodes = node.getChildNodes();

        // Traverse through the child nodes
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);

            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                printNode((Element) childNode);
            }
        }
    }
}