import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_07843_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a factory for building DOM tree
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling XML content
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the content of the XML file
            Document doc = builder.parse("example.xml");

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Print the value of the first node in the root element
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Get all nodes of the document
            NodeList nodes = doc.getElementsByTagName("node");

            // Print the number of nodes
            System.out.println("Number of nodes: " + nodes.getLength());

            // Print the value of each node
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}