import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08785_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder to parse the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse("src/main/resources/example.xml");

            // Print the document nodes and attributes
            printDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        // Print the document nodes and attributes
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // Iterate over all child nodes of the root element
        for (int i = 0; i < doc.getDocumentElement().getChildNodes().getLength(); i++) {
            Node node = doc.getDocumentElement().getChildNodes().item(i);
            System.out.println("Child node " + (i + 1) + ": " + node.getNodeName());
        }
    }
}