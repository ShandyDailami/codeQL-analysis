import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_16466_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();

            // Print all the text in the document
            printNodes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print all text in the document
    private static void printNodes(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Element Name: " + element.getNodeName());
            System.out.println("Element Value: " + element.getNodeValue());
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            System.out.println("Text Node: " + node.getNodeValue());
        }

        // Recursive call for all children
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printNodes(children.item(i));
        }
    }
}