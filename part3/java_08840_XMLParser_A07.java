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

public class java_08840_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all 'node' elements
            NodeList nodes = root.getElementsByTagName("node");

            // Process each 'node' element
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Extract the node's value
                String value = node.getTextContent();

                // Perform security-sensitive operation
                // For example, log the value
                System.out.println("Processing node value: " + value);

                // Write the processed value to an XML file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(node);
                StreamResult result = new StreamResult(new File("processed_nodes.xml"));
                transformer.transform(source, result);
            }

            System.out.println("XML file has been written successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}