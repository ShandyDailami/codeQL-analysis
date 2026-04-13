import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_06703_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element
            Element rootElement = doc.getDocumentElement();

            // Print all the text in the document
            printNode(rootElement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node) {
        if (node.hasChildNodes()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                printNode(child);
            }
        } else {
            System.out.println(node.getTextContent());
        }
    }
}