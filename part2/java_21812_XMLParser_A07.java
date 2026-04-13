import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_21812_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Use factory to create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use builder to parse the file
            Document doc = builder.parse(new File("sample.xml"));

            // Normalize the document to prevent any whitespace differences
            doc.normalize();

            // Get all the elements from the document
            NodeList nodes = doc.getElementsByTagName("node");
            List<String> values = parseXML(nodes);

            // Print the values
            for (String value : values) {
                System.out.println(value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> parseXML(NodeList nodes) {
        // Initialize an empty list
        List<String> values = new ArrayList<>();
        // Iterate through each node
        for (int i = 0; i < nodes.getLength(); i++) {
            // Retrieve the current node
            Element element = (Element) nodes.item(i);
            // Get the value of the node
            String value = element.getTextContent();
            // Add the value to the list
            values.add(value);
        }
        return values;
    }
}