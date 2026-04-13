import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_05313_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder from the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Print all the node names and their corresponding values
            printNode(doc, doc.getDocumentElement());

            // Create a transformer factory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Create a transformer from the factory
            Transformer transformer = transformerFactory.newTransformer();

            // Create an output document
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);

            // Transform the source document into an output document
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Document doc, Element node) {
        System.out.println("\nNode name: " + node.getNodeName());
        if (node.hasChildNodes()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                if (child.getNodeType() == Node.TEXT_NODE)
                    System.out.println("Child Node: " + child.getNodeValue());
                else
                    printNode(doc, child.getChildNodes());
            }
        }
    }
}