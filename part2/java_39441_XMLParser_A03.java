import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_39441_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create an instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder with the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(getInputFile());

            // Print the document elements and attributes
            printDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInputFile() {
        return new FileInputStream("src/main/resources/input.xml");
    }

    private static void printDocument(Document doc) {
        // Print the document elements and attributes
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // Iterate over each child of the root element
        for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
            printNode(doc.getChildNodes().item(i));
        }
    }

    private static void printNode(org.w3c.dom.Node node) {
        // Print the node name and attributes
        System.out.println("Node name: " + node.getNodeName());

        // Iterate over each child of the node
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            printNode(node.getChildNodes().item(i));
        }
    }
}