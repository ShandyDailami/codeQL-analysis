import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_36229_XMLParser_A07 {

    public static void main(String[] args) {
        // Path to the XML file
        String filePath = "path/to/your/file.xml";

        // Parse the XML document
        parseXMLDocument(filePath);
    }

    private static void parseXMLDocument(String filePath) {
        try {
            // Create a factory for the document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse(new File(filePath));

            // Get all the nodes in the document
            NodeList nodeList = document.getElementsByTagName("node");

            // Process each node
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nodeName = element.getNodeName();
                    String nodeValue = element.getTextContent();
                    System.out.println("Node Name: " + nodeName + ", Node Value: " + nodeValue);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}