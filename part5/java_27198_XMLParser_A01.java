import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_27198_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for building DOM trees
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a builder for handling the actual XML file
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML document
            Document doc = builder.parse("input.xml");

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Find all 'item' nodes
            NodeList nodes = doc.getElementsByTagName("item");

            // Process all 'item' nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                // Create a new transformer
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(nodes.item(i));
                StreamResult result = new StreamResult("output" + (i + 1) + ".xml");
                // Write the node to the output file
                transformer.transform(source, result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}