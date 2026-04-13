import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_07480_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Print out the tags and attributes
            printNode(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node) {
        if (node.hasChildNodes()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                if (child.getNodeType() == Node.TEXT_NODE && ((Text) child).getNodeValue().trim().length() > 0) {
                    System.out.println("Tag: " + child.getNodeName() + ", Text: " + ((Text) child).getNodeValue());
                } else {
                    printNode(child);
                }
            }
        } else if (node.getNodeType() == Node.TEXT_NODE && ((Text) node).getNodeValue().trim().length() > 0) {
            System.out.println("Tag: " + node.getNodeName() + ", Text: " + ((Text) node).getNodeValue());
        }
    }
}