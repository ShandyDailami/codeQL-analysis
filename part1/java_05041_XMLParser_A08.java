import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_05041_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document from the file
            Document doc = builder.parse("resources/example.xml");

            // Retrieve the root element of the Document
            doc.getDocumentElement().normalize();

            // Get the list of all tags
            NodeList tags = doc.getElementsByTagName("*");

            // Iterate over the list of tags
            for (int i = 0; i < tags.getLength(); i++) {
                // Print out the name of the current tag and its value
                System.out.println("Tag: " + tags.item(i).getNodeName() + ", Value: " + tags.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}