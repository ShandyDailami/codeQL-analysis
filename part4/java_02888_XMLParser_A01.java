import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_02888_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Set Security-sensitive settings
            factory.setValidate(false); // Do not validate the XML document
            factory.setNamespaceAware(false); // Do not enforce XML namespaces
            factory.setXInclude(false); // Do not include external entities
            factory.setXRefResolver(null); // Do not use external XRef

            // Step 3: Use DocumentBuilderFactory to create a Document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/test.xml");

            // Step 4: Print all elements and attributes of the XML document
            Element root = doc.getDocumentElement();
            printNode(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Element node) {
        // Base case: if the node is null, return
        if (node == null) {
            return;
        }

        // Print node name and its attributes
        System.out.println("Node name: " + node.getNodeName());
        System.out.println("Node text: " + node.getTextContent());

        // Recursively print all child nodes
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            printNode(node.getChildNodes().item(i));
        }
    }
}